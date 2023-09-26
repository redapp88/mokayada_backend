package letapp.dev.mokayada.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import letapp.dev.mokayada.entities.Offer;
@Service
public interface OfferService  {

	public Offer getOffer(Long id);
	public Page<Offer> getListOffer(String city, String categorie, String keyword,int page, int size);
	public Page<Offer> getListOffer(Long userId,int page, int size);
}
