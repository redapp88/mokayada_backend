package letapp.net.mokayada.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import letapp.net.mokayada.entities.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {

}
