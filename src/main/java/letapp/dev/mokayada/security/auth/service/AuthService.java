package letapp.dev.mokayada.security.auth.service;

import java.util.Optional;
import letapp.dev.mokayada.security.users.Requests.UsersRequest;
import letapp.dev.mokayada.security.users.model.Users;
public interface AuthService {
    public Optional<Users> AddUser(UsersRequest user);
}
