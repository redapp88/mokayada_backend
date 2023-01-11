package letapp.net.mokayada.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

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
public class AppUser {
	@Id
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String sex;
	private String phone;
	private String birthDate;
	private Date subscribeDate;
	@OneToMany
	private List<Offer> offers;
	@ManyToOne
	private AppRole appRole;

}
