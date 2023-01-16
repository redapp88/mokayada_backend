package letapp.net.mokayada.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import letapp.net.mokayada.entities.Deal;

public interface DealRepository extends JpaRepository<Deal, String> {
 
}
