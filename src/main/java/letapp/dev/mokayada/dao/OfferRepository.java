package letapp.dev.mokayada.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import letapp.dev.mokayada.entities.Offer;
import letapp.dev.mokayada.responses.ProposalWithOfferResponse;

public interface OfferRepository extends JpaRepository<Offer, Long> {
	
	@Query("select o from Offer o where o.owner.username not like :seacher and o.parentOffer is null and o.city like :city and o.categorie like :categorie and o.description like :keyword ")
	public Page<Offer> getOffers(@Param("seacher")String searcher,@Param("city")String city, @Param("categorie")String categorie,@Param("keyword") String keyword,Pageable pageable);
	@Query("select o from Offer o where o.owner.username like :username and (o.title like :username or o.description like :description) order by o.creationDate DESC")
	public List<Offer> getOffersByUser(@Param ("username")String username,@Param("description")String description);
	@Query("select o from Offer o where o.owner.id = :userId ")
	public Page<Offer> getOffers(@Param("userId")Long userId, Pageable pageable);
	@Query("select o from Offer o where o.parentOffer is not null and o.owner.username like :username")
	public List<Offer> getProposalesByUsername(@Param("username")String username);

}
