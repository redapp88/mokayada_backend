package letapp.dev.mokayada.services;

import java.util.List;

import letapp.dev.mokayada.entities.AppPhoto;
import letapp.dev.mokayada.requests.AppPhotosRequest;

public interface AppPhotoService {

	public void saveAll(AppPhotosRequest appPhotosRequest);

	public void editPhotos(Long id, AppPhotosRequest appPhotosRequest);

	public List<AppPhoto> getAllByItem(String itemId);

}
