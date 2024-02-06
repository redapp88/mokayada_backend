package letapp.dev.mokayada.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import letapp.dev.mokayada.dao.AppPhotosRepository;
import letapp.dev.mokayada.dao.AppUserRepository;
import letapp.dev.mokayada.dao.ItemRepository;
import letapp.dev.mokayada.dao.OfferRepository;
import letapp.dev.mokayada.entities.AppUser;
import letapp.dev.mokayada.entities.Item;
import letapp.dev.mokayada.entities.Offer;
import letapp.dev.mokayada.requests.ItemRequest;
import letapp.dev.mokayada.requests.OfferWithItemsRequest;
import letapp.dev.mokayada.responses.ItemsListsResponse;

@Service
public class ItemsServiceImp implements ItemsService {
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private AppPhotosRepository appPhotosRepository;
	@Autowired
	private OfferService offerService;
	@Autowired
	private OfferRepository offerRepository;
	

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
		if(this.offerRepository.getByItem(item).size()>0)
			throw new RuntimeException("Cet item fait partie d'une offre ou proposition supprimer la ou enlever l'item");
		 item.setDeleted(true);
		 this.itemRepository.save(item);
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



	@Override
	public ItemsListsResponse getItemsByOffer(String username,Long offerId) {
		List<Item> offerItems = this.itemRepository.getByOfferId(offerId);
		List<Item> usersItems=this.itemRepository.getItemsByUser(username);
		List<Item>availableItems = new ArrayList<Item>();
		usersItems.stream().forEach(e->{
			if(!offerItems.contains(e))
				availableItems.add(e);
		});
		 return new ItemsListsResponse(availableItems,offerItems);
	}



	@Override
	public void saveItemsToOffer(Long offerId, OfferWithItemsRequest offerWithItemsRequest) {
		Offer offer = this.offerService.getOffer(offerId);
		offerWithItemsRequest.getItems().forEach(i->{
			i.setOffer(offer);
			this.itemRepository.save(i);
		});
		offer.getItems().clear();
		offer.getItems().addAll(offerWithItemsRequest.getItems());
		offer.setTitle(offerWithItemsRequest.getOfferRequest().getTitle());
		offer.setDescription(offerWithItemsRequest.getOfferRequest().getDescription());
		offer.setCity(offerWithItemsRequest.getOfferRequest().getCity());
		offer.setCategorie(offerWithItemsRequest.getOfferRequest().getCategorie());
		offerRepository.save(offer);
		
		
	}



	@Override
	public List<Item> getItemsByUser(String username) {
		return this.itemRepository.getItemsByUser(username);
	}

}
