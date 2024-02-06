package letapp.dev.mokayada.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import letapp.dev.mokayada.entities.AppUser;
import letapp.dev.mokayada.requests.AppUserSubscibeRequest;
@Service
public interface AppUsersService extends UserDetailsService {

	public AppUser add(AppUserSubscibeRequest user);
	public AppUser getUser(String username);
	public AppUser upDateUser(String username, AppUserSubscibeRequest userRequest);
	

}
