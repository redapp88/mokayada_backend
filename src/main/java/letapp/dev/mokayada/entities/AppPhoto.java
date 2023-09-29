package letapp.dev.mokayada.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class AppPhoto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String url;
	@ManyToOne
	private Item item;
	public AppPhoto(String title, String url,Item item) {
		super();
		this.title = title;
		this.url = url;
		this.item=item;
	}
	
	
}
