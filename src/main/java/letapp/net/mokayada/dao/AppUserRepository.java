package letapp.net.mokayada.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import letapp.net.mokayada.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String>{

}
