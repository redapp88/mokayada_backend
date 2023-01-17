package letapp.net.mokayada.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import letapp.net.mokayada.entities.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {
	@Query("Select o from Offer o where o.title like :keyword or o.description like :keyword")
	public List<Offer> findByKeyword(@Param(value = "keyword") String keyword);

}
