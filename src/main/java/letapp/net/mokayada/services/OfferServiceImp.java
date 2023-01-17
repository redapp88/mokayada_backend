package letapp.net.mokayada.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import letapp.net.mokayada.converters.OfferConverter;
import letapp.net.mokayada.dao.OfferRepository;
import letapp.net.mokayada.domaine.OfferVo;
import letapp.net.mokayada.entities.Offer;
@Service
public class OfferServiceImp implements OfferService {
	@Autowired
	private OfferRepository offerRepository;

	@Override
	public List<OfferVo> findOffersByKeyword(String keyword) {
		String localkeyword = "%" + keyword + "%";
		if (keyword == "")
			localkeyword = "%";
		List<Offer> offers = this.offerRepository.findByKeyword(localkeyword);
		return OfferConverter.toListVo(offers);
	}

}
