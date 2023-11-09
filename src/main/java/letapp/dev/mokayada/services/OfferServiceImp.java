package letapp.dev.mokayada.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import letapp.dev.mokayada.dao.OfferRepository;
import letapp.dev.mokayada.entities.Offer;

@Service
public class OfferServiceImp implements OfferService {
	@Autowired
	private OfferRepository offerRepository;

	@Override
	public Offer getOffer(Long id) {
		Optional<Offer> offerOptional = this.offerRepository.findById(id);
		if (offerOptional.isPresent())
			return offerOptional.get();
		else
			return null;
	}

	@Override
	public Page<Offer> getListOffer(String city, String categorie, String keyword, int page, int size) {
		/*
		 * System.out.println(this.formatParam(city));
		 * System.out.println(this.formatParam(categorie));
		 * System.out.println(this.formatParam(keyword)); System.out.println(page);
		 * System.out.println(size);
		 */

		return this.offerRepository.getOffers(this.formatParam(city), this.formatParam(categorie), this.formatParam(keyword), PageRequest.of(page, size));

	}

	@Override
	public Page<Offer> getListOffer(Long userId, int page, int size) {
		return this.offerRepository.getOffers(userId, PageRequest.of(page, size));
	}

	private String formatParam(String param) {
		if (param.equals("*") || param.equals("") )
			return "%%";
		else
			return "%" + param + "%";
	}

}
