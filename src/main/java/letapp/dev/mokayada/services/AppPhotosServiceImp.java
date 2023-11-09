package letapp.dev.mokayada.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import letapp.dev.mokayada.dao.AppPhotosRepository;
import letapp.dev.mokayada.dao.ItemRepository;
import letapp.dev.mokayada.entities.AppPhoto;
import letapp.dev.mokayada.entities.Item;
import letapp.dev.mokayada.requests.AppPhotosRequest;
@Service
public class AppPhotosServiceImp implements AppPhotoService {
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private AppPhotosRepository appPhotosRepository;
	

	@Override
	public void saveAll(AppPhotosRequest appPhotosRequest) {
		Item item = this.itemRepository.getById(appPhotosRequest.getItemId());
		if (item == null)
			throw new RuntimeException("Item Introuvable");
		List<AppPhoto> photos = appPhotosRequest.getPhotos();

		photos.forEach(photo->{
			photo.setItem(item);
			item.getPhotos().add(photo);
		});
		this.appPhotosRepository.saveAll(photos);
		this.itemRepository.save(item);

	}

	@Override
	public void editPhotos(Long id, AppPhotosRequest appPhotosRequest) {
		Item item = this.itemRepository.getById(id);
		if (item == null)
			throw new RuntimeException("Item Introuvable");
		
		item.getPhotos().removeAll(appPhotosRequest.getDeletedPhotos());
		
		
		List<AppPhoto> photos = appPhotosRequest.getPhotos();

		photos.forEach(photo->{
			photo.setItem(item);
			item.getPhotos().add(photo);
		});
		this.appPhotosRepository.saveAll(photos);
		this.itemRepository.save(item);
	}

	@Override
	public List<AppPhoto> getAllByItem(String itemId) {
		// TODO Auto-generated method stub
		return null;
	}

}
