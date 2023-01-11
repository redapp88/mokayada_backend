package letapp.net.mokayada.entities;

import java.util.Date;
import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offer {
	private Long id;
	private Date CreationDate;
	@OneToMany
	private Map<Product, Integer> products;
	private boolean deal;
	@ManyToOne
	private AppUser user;

}
