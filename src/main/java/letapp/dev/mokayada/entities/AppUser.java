package letapp.dev.mokayada.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(unique = true)
private String username;
private String firstName;
private String lastName;
private String sex;
private String phone;
private String Email;
private Date subscribeDate;
private Date birthDate;
private String Password;
@ManyToOne
private AppRole role;



public AppUser( String username, AppRole role) {
	super();
	this.username = username;
	this.subscribeDate = new Date();
	this.role = role;
}



}
