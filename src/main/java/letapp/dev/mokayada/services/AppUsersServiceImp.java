package letapp.dev.mokayada.services;

import java.util.Date;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import letapp.dev.mokayada.dao.AppRoleRepository;
import letapp.dev.mokayada.dao.AppUserRepository;
import letapp.dev.mokayada.entities.AppRole;
import letapp.dev.mokayada.entities.AppUser;
import letapp.dev.mokayada.requests.AppUserSubscibeRequest;
import letapp.dev.mokayada.security.ExtendedUser;

@Service
public class AppUsersServiceImp implements AppUsersService {
	@Autowired
	private AppUserRepository usersRepository;
	@Autowired
	private AppRoleRepository appRoleRepository;
	//@Autowired
	//private BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usersRepository.findByUsername(username).map(ExtendedUser::new)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found!"));
	}

	@Override
	public AppUser add(AppUserSubscibeRequest userRequest) {
		System.out.println(userRequest);
		AppUser user =new AppUser();
		AppRole role = this.appRoleRepository.getByroleName("USER");
		if(role == null) {
			throw new RuntimeException("Erreur Technique");
		}

		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setBirthDate(userRequest.getBirthDate());
		user.setSex(userRequest.getSex());
		user.setEmail(userRequest.getEmail());
		user.setPhone(userRequest.getPhone());
		user.setUsername(userRequest.getUsername());
		System.out.println(user);
		//user.setPassword(this.encoder.encode(userRequest.getPassword()));
		user.setState("panding");
		user.setRole(role);
		user.setSubscribeDate(new Date());

		return this.usersRepository.save(user);

	}

	@Override
	public AppUser getUser(String username) {
		Optional<AppUser> userOpt = this.usersRepository.findById(username);
		if(userOpt.isPresent())
			return userOpt.get();
		else 
			throw new RuntimeException("Utilisateur introuvable");
	}

	@Override
	public AppUser upDateUser(String username, AppUserSubscibeRequest userRequest) {
		AppUser user = this.getUser(username);
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setBirthDate(userRequest.getBirthDate());
		user.setBirthDate(userRequest.getBirthDate());
		user.setSex(userRequest.getSex());
		user.setEmail(userRequest.getEmail());
		user.setPhone(userRequest.getPhone());
		//System.out.println(user);
		
		return this.usersRepository.save(user);
	}

}
