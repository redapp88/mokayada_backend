package letapp.dev.mokayada.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import letapp.dev.mokayada.dao.AppUserRepository;
import letapp.dev.mokayada.dao.OfferRepository;
import letapp.dev.mokayada.entities.AppUser;
import letapp.dev.mokayada.entities.Offer;
import letapp.dev.mokayada.requests.OfferRequest;
import letapp.dev.mokayada.requests.ProposalRequest;
import letapp.dev.mokayada.responses.ProposalWithOfferResponse;

@Service
public class OfferServiceImp implements OfferService {
	@Autowired
	private OfferRepository offerRepository;
	@Autowired
	private AppUserRepository appUserRepository;

	@Override
	public Offer getOffer(Long id) {
		Optional<Offer> offerOptional = this.offerRepository.findById(id);
		if (offerOptional.isPresent())
			return offerOptional.get();
		else
			return null;
	}

	@Override
	public Page<Offer> getListOffer(String searcher, String city, String categorie, String keyword, int page,
			int size) {
		/*
		 * System.out.println(this.formatParam(city));
		 * System.out.println(this.formatParam(categorie));
		 * System.out.println(this.formatParam(keyword)); System.out.println(page);
		 * System.out.println(size);
		 */
		return this.offerRepository.getOffers(searcher, this.formatParam(city), this.formatParam(categorie),
				this.formatParam(keyword), PageRequest.of(page, size));

	}

	@Override
	public Page<Offer> getListOffer(Long userId, int page, int size) {
		return this.offerRepository.getOffers(userId, PageRequest.of(page, size));
	}

	private String formatParam(String param) {
		if (param.equals("*") || param.equals(""))
			return "%%";
		else
			return "%" + param + "%";
	}

	@Override
	public List<Offer> getOffersByUser(String username, String keyword) {
		return this.offerRepository.getOffersByUser(username, formatParam(keyword));

	}

	@Override
	public Offer add(OfferRequest request) {
		Optional<AppUser> userOpt = this.appUserRepository.findByUsername(request.getUsername());
		if (!userOpt.isPresent())
			throw new RuntimeException("Utilisateur introuvable");
		Offer newOffer = new Offer(request.getTitle(), request.getDescription(), "FREE", request.getCity(),
				request.getCategorie(), null, userOpt.get());
		newOffer.setId(1L);
		//System.out.println("§§§§§§§§§§§§§§§§");
		//System.out.println(newOffer);

		/*
		 * request.getPhotoIds().forEach(id -> { Optional<AppPhoto> photoOpt =
		 * this.appPhotosRepository.findById(id); if (photoOpt.isPresent())
		 * newItem.getPhotos().add(photoOpt.get()); });
		 */
		return this.offerRepository.save(newOffer);
	}

	@Override
	public Offer addProposal(ProposalRequest request) {
		Offer offer = this.getOffer(request.getOfferId());
		AppUser user = this.appUserRepository.getById(request.getUsername());
		if (offer == null || user == null)
			throw new RuntimeException("Offre ou utilisateur introuvable");
		Offer proposal = new Offer();
		proposal.setOwner(user);
		proposal.setItems(request.getItems());
		proposal.setCreationDate(new Date());
		proposal.setCategorie(null);
		proposal.setCity(null);
		proposal.setDescription(null);
		proposal.setStatus("ACTIF");
		proposal.setTitle("Proposition à l'offre " + offer.getTitle());
		proposal.setParentOffer(offer);
		proposal = this.offerRepository.save(proposal);
		offer.getPropositions().add(proposal);
		offer = this.offerRepository.save(offer);
		this.offerRepository.save(proposal);
		this.updateOfferStatus(offer);
		return null;
	}

	@Override
	public Offer updateProposal(ProposalRequest request) {
		Offer proposal = this.getOffer(request.getOfferId());
		AppUser user = this.appUserRepository.getById(request.getUsername());
		if (proposal == null || user == null)
			throw new RuntimeException("Offre ou utilisateur introuvable");
		proposal.setItems(request.getItems());
		return this.offerRepository.save(proposal);
	}

	@Override
	public List<ProposalWithOfferResponse> getProposales(String username) {
		return this.offerRepository.getProposalesByUsername(username).stream()
				.map(o -> new ProposalWithOfferResponse(o, o.getParentOffer())).collect(Collectors.toList());

	}

	@Override
	public void deleteProposal(Long id) {
		Offer proposal = this.getOffer(id);
		Offer parentOffer = proposal.getParentOffer();
		parentOffer.getPropositions().remove(proposal);
		this.offerRepository.deleteById(id);
		this.updateOfferStatus(parentOffer);

	}

	private void updateOfferStatus(Offer offer) {
		if (offer.getPropositions().size() > 0)
			offer.setStatus("HASPROPOSALS");
		else
			offer.setStatus("FREE");
	}

	@Override
	public Offer acceptProposal(Offer proposal) {
		Offer loadedProposal = this.getOffer(proposal.getId());
		loadedProposal.setStatus("ACCEPTED");
		loadedProposal.getParentOffer().setStatus("CONCLUDED");
		this.offerRepository.save(loadedProposal);
		return loadedProposal;

	}

	@Override
	public void deleteOffer(Long id) {
		Offer offer = this.getOffer(id);
		this.offerRepository.delete(offer);

	}

	@Override
	public Page<ProposalWithOfferResponse> getMyContracts(String username, int page, int size) {

		List<Offer> result = this.offerRepository.getMyConcludedOffers(username);
		
		List<ProposalWithOfferResponse> resp = result.stream().map(offer -> new ProposalWithOfferResponse(offer.getPropositions().stream()
					.filter(p -> p.getStatus().equals("ACCEPTED")).collect(Collectors.toList()).get(0),offer )).collect(Collectors.toList());

		 return new PageImpl<ProposalWithOfferResponse>(resp, PageRequest.of(page, size), resp.size());
	}

	@Override
	public Page<ProposalWithOfferResponse> getReceivedContracts(String username, int page, int size) {
		List<Offer> result= this.offerRepository.getAcceptedProposals(username);
		
		
		List<ProposalWithOfferResponse> resp = result.stream().map(offer -> new ProposalWithOfferResponse(offer,offer.getParentOffer())).collect(Collectors.toList());

		 return new PageImpl<ProposalWithOfferResponse>(resp, PageRequest.of(page, size), resp.size());
	}

}
