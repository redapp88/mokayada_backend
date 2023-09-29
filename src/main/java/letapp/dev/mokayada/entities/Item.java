package letapp.dev.mokayada.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private String status;
	private Date creationDate;
	@ManyToOne
	private AppUser owner;
	@OneToMany
	private List<AppPhoto> photos;
	public Item(String title, String description, String status, List<AppPhoto> photos,AppUser owner) {
		super();
		this.title = title;
		this.description = description;
		this.creationDate = new Date();
		this.status = status;
		this.photos = photos;
		this.owner = owner;
	}
	
	
	
}
