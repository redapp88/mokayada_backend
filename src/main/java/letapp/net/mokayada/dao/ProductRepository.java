package letapp.net.mokayada.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import letapp.net.mokayada.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
