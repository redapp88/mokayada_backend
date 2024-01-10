package letapp.dev.mokayada.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

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

public class AppUser implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
private String username;
private String firstName;
private String lastName;
private String sex;
private String phone;
private String Email;
private Date subscribeDate;
private Date birthDate;
private String Password;
private String state;
@ManyToOne
private AppRole role;



public AppUser( String username, AppRole role) {
	super();
	this.username = username;
	this.subscribeDate = new Date();
	this.role = role;
	this.state="panding";
}

public List <GrantedAuthority>rolesToAuthorities() {
	ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	GrantedAuthority authority=new SimpleGrantedAuthority(this.getRole().getRoleName());
	authorities.add(authority);
	return authorities;
	
}



}
