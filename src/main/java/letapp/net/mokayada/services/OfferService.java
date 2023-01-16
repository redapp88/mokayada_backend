package letapp.net.mokayada.services;

import java.util.List;

import letapp.net.mokayada.entities.Offer;

public interface OfferService {

	public List<OfferVo> findOffersByKeyword(String keyword);
}
