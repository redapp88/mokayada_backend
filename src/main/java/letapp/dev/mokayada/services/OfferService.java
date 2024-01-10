package letapp.dev.mokayada.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import letapp.dev.mokayada.entities.Offer;
import letapp.dev.mokayada.requests.OfferRequest;
import letapp.dev.mokayada.requests.ProposalRequest;
import letapp.dev.mokayada.responses.ProposalWithOfferResponse;
@Service
public interface OfferService  {

	public Offer getOffer(Long id);
	public Page<Offer> getListOffer(String searcher,String city, String categorie, String keyword,int page, int size);
	public Page<Offer> getListOffer(Long userId,int page, int size);
	public List<Offer> getOffersByUser(String username, String keyword);
	public Offer add(OfferRequest request);
	public Offer addProposal(ProposalRequest request);
	public Offer updateProposal(ProposalRequest request);
	public List<ProposalWithOfferResponse> getProposales(String username);
	public void delete(Long id);
}
