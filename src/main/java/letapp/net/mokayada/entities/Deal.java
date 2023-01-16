package letapp.net.mokayada.entities;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deal {
	@Id
	private String id;
	@OneToOne
	private Offer offer;
	@OneToOne
	private Proposal proposal;
}
