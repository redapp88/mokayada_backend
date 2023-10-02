package letapp.dev.mokayada.security.auth.service;

import java.util.Optional;

import letapp.dev.mokayada.entities.AppUser;
import letapp.dev.mokayada.security.users.Requests.UsersRequest;
public interface AuthService {
    public Optional<AppUser> AddUser(UsersRequest user);
}
