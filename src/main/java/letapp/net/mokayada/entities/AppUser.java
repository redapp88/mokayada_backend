package letapp.net.mokayada.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
	@Id
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String sex;
	private String phone;
	private String birthDate;
	private String localisation;
	private Date subscribeDate;
	@OneToMany (mappedBy = "user")
	private List<Offer> offers  = new ArrayList<Offer>();
	@ManyToOne
	private AppRole appRole;
	@OneToMany(mappedBy = "user")
	private List<Proposal> proposales = new ArrayList<Proposal>();

}
