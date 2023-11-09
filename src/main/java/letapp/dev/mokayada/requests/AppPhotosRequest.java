package letapp.dev.mokayada.requests;

import java.util.List;

import letapp.dev.mokayada.entities.AppPhoto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppPhotosRequest {
	private Long itemId;
	private List<AppPhoto> photos;
	private List<AppPhoto> deletedPhotos;

}
