package letapp.net.mokayada.domaine;

import java.util.Date;
import java.util.List;

import lombok.Data;
@Data
public class ProductVo {
	private Long id;
	private String title;
	private String descrition;
	private Date creationDate;
	private Date updateDate;
	private List<AppPhotoVo> photos;
}
