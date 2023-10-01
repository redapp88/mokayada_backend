package letapp.dev.mokayada.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import letapp.dev.mokayada.entities.AppUser;


public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	public Optional<AppUser> getByUsername(String username);

}
