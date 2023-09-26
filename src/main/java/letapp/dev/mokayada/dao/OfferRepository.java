package letapp.dev.mokayada.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import letapp.dev.mokayada.entities.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {
	
	@Query("select o from Offer o where o.city like :city and o.categorie like :categorie and o.description like :keyword ")
	public Page<Offer> getOffers(@Param("city")String city, @Param("categorie")String categorie,@Param("keyword") String keyword,Pageable pageable);
	@Query("select o from Offer o where o.owner.id = :userId ")
	public Page<Offer> getOffers(@Param("userId")Long userId, Pageable pageable);

}
