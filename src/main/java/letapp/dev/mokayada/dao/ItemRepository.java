package letapp.dev.mokayada.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import letapp.dev.mokayada.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	@Query("select i from Item i where i.owner.username like :username order by i.creationDate DESC")
	public Page<Item> getItems(@Param("username")String username, Pageable pageable);

}
