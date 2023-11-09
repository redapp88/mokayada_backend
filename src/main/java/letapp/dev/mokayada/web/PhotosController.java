package letapp.dev.mokayada.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import letapp.dev.mokayada.entities.AppPhoto;
import letapp.dev.mokayada.requests.AppPhotosRequest;
import letapp.dev.mokayada.services.AppPhotoService;

@RestController
@RequestMapping("/api/v1/auth/photos")
public class PhotosController {
	@Autowired
	AppPhotoService appPhotosService;
	@PostMapping("/add")
	public void addPhotos(@RequestBody AppPhotosRequest appPhotosRequest ) {
	try {
		this.appPhotosService.saveAll(appPhotosRequest);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	@PutMapping("/update/{id}")
	public void editImages(@PathVariable Long id,@RequestBody AppPhotosRequest appPhotosRequest){
		this.appPhotosService.editPhotos(id,appPhotosRequest);

	}

	@GetMapping()
	public List<AppPhoto> imagesByDocument(@RequestParam String itemId){
		List<AppPhoto> images = this.appPhotosService.getAllByItem(itemId);
		 return images;
	}

}
