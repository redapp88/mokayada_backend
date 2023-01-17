package letapp.net.mokayada.services;

import java.util.List;

import letapp.net.mokayada.domaine.OfferVo;

public interface OfferService {

	public List<OfferVo> findOffersByKeyword(String keyword);
}
