package letapp.dev.mokayada.security.users.service;


import java.util.List;

import letapp.dev.mokayada.security.users.Requests.UsersRequest;
import letapp.dev.mokayada.security.users.model.Users;

public interface UsersService {
    public List<Users> GetAllUsers();

    public Users AddUser(UsersRequest user);
}
