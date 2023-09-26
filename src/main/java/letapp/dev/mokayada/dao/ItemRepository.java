package letapp.dev.mokayada.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import letapp.dev.mokayada.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
