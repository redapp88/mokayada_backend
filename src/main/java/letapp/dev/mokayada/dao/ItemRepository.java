package letapp.dev.mokayada.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import letapp.dev.mokayada.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	@Query("select i from Item i where i.owner.username like :username and i.deleted = false order by i.creationDate DESC")
	public Page<Item> getItems(@Param("username") String username, Pageable pageable);

	@Query("select i from Item i where i.offer.id = :offerId and i.deleted = false order by i.creationDate DESC ")
	public List<Item> getByOfferId(@Param("offerId") Long offerId);
	@Query("select i from Item i where i.owner.username like :username and i.deleted = false order by i.creationDate DESC")
	public List<Item> getItemsByUser(@Param("username") String username);
	

}
