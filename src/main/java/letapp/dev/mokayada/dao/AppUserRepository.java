package letapp.dev.mokayada.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import letapp.dev.mokayada.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

	public Optional<AppUser> findByUsername(String username);

}
