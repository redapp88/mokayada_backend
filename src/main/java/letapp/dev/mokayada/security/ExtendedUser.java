 package letapp.dev.mokayada.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import letapp.dev.mokayada.entities.AppUser;
import lombok.ToString;
@ToString
public class ExtendedUser extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String state;

public ExtendedUser(String username, String password,String firstName,String lastName,String state, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.firstName=firstName;
		this.lastName=lastName;

	}
public ExtendedUser (AppUser appUser) {
	
	super(appUser.getUsername(), appUser.getPassword(), appUser.rolesToAuthorities());
	this.firstName=appUser.getFirstName();
	this.lastName=appUser.getLastName();
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}

}
