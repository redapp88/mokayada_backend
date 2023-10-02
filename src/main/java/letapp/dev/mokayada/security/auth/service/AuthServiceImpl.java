package letapp.dev.mokayada.security.auth.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import letapp.dev.mokayada.dao.AppUserRepository;
import letapp.dev.mokayada.entities.AppUser;
import letapp.dev.mokayada.security.users.Requests.UsersRequest;
import letapp.dev.mokayada.security.users.model.Users;
import letapp.dev.mokayada.security.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final AppUserRepository usersRepository;

    public Optional<AppUser> AddUser(UsersRequest user) {
        AppUser newUser = new AppUser();
		/*
		 * newUser.setFirst_name(user.getFirst_name());
		 * newUser.setLast_name(user.getLast_name()); newUser.setEmail(user.getEmail());
		 * newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		 * newUser.setRoles("ROLE_USER");
		 */
        return Optional.of(usersRepository.save(newUser));
    }
}
