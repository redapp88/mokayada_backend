package letapp.dev.mokayada.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import letapp.dev.mokayada.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

}
