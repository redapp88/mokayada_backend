package letapp.net.mokayada.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import letapp.net.mokayada.entities.AppPhoto;

public interface AppPhotoRepository extends JpaRepository<AppPhoto, Long>{
	

}
