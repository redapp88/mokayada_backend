package letapp.dev.mokayada.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import letapp.dev.mokayada.dao.AppPhotosRepository;
import letapp.dev.mokayada.dao.AppUserRepository;
import letapp.dev.mokayada.dao.ItemRepository;
import letapp.dev.mokayada.entities.AppPhoto;
import letapp.dev.mokayada.entities.AppUser;
import letapp.dev.mokayada.entities.Item;
import letapp.dev.mokayada.requests.ItemRequest;

@Service
public class ItemsServiceImp implements ItemsService {
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private AppPhotosRepository appPhotosRepository;

	@Override
	public Page<Item> getListItems(String username, int page, int size) {
		return this.itemRepository.getItems( this.formatParam(username), PageRequest.of(page, size));
	}



	@Override
	public Item addItem(ItemRequest request) {
		Optional<AppUser> userOpt = this.appUserRepository.findByUsername(request.getUsername());
		if (!userOpt.isPresent())
			throw new RuntimeException("Utilisateur introuvable");
		System.out.println(request.getStatus());
		Item newItem = new Item(request.getTitle(), request.getStatus(), request.getDescription(), userOpt.get());
		
		/*
		 * request.getPhotoIds().forEach(id -> { Optional<AppPhoto> photoOpt =
		 * this.appPhotosRepository.findById(id); if (photoOpt.isPresent())
		 * newItem.getPhotos().add(photoOpt.get()); });
		 */
		return this.itemRepository.save(newItem);

	}

	@Override
	public Item updateItem(Long itemId, ItemRequest request) {
		Optional<Item> itemOpt = this.itemRepository.findById(itemId);
		if (!itemOpt.isPresent())
			throw new RuntimeException("item introuvable");
		Item item = itemOpt.get();
		item.setTitle(request.getTitle());
		item.setDescription(request.getDescription());
		item.setStatus(request.getStatus());
		/*
		 * request.getPhotoIds().forEach(id -> { Optional<AppPhoto> photoOpt =
		 * this.appPhotosRepository.findById(id); if (photoOpt.isPresent())
		 * item.getPhotos().add(photoOpt.get()); });
		 */
		return this.itemRepository.save(item);
	}

	@Override
	public void delete(Long itemId) {
		Optional<Item> itemOpt = this.itemRepository.findById(itemId);
		if (!itemOpt.isPresent())
			throw new RuntimeException("item introuvable");
		Item item = itemOpt.get();
		 this.itemRepository.delete(item);
	}
	
	private String formatParam(String param) {
		if (param.equals("*") || param.equals("") )
			return "%%";
		else
			return "%" + param + "%";
	}



	@Override
	public Item getItem(Long id) {
		Optional<Item> itemOpt = this.itemRepository.findById(id);
		if(!itemOpt.isPresent()){
			throw new RuntimeException("Item introuvable");
		}
		return itemOpt.get();
	}

}
