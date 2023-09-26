package letapp.dev.mokayada.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import letapp.dev.mokayada.entities.AppPhoto;

public interface AppPhotosRepository extends JpaRepository<AppPhoto, Long> {

}
