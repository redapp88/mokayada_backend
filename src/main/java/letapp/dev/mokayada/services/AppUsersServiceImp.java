package letapp.dev.mokayada.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import letapp.dev.mokayada.dao.AppUserRepository;
import letapp.dev.mokayada.security.ExtendedUser;

@Service
public class AppUsersServiceImp implements AppUsersService {
	@Autowired
	private AppUserRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usersRepository.findByUsername(username).map(ExtendedUser::new)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found!"));
	}

}
