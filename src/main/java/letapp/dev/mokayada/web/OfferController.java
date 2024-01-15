package letapp.dev.mokayada.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import letapp.dev.mokayada.entities.Offer;
import letapp.dev.mokayada.requests.OfferRequest;
import letapp.dev.mokayada.requests.ProposalRequest;
import letapp.dev.mokayada.responses.ProposalWithOfferResponse;
import letapp.dev.mokayada.services.OfferService;

@RestController
@RequestMapping("/api/v1/offers")
public class OfferController {
	@Autowired
	private OfferService offerService;
@GetMapping("/getOne")
public Offer getOffer(@RequestParam Long offerId) {
	return this.offerService.getOffer(offerId);
}
@GetMapping("/byParams")
public Page<Offer> getOffers(@RequestParam(defaultValue = "null")String searcher,@RequestParam(defaultValue = "*") String city,@RequestParam(defaultValue = "*") String categorie,@RequestParam(defaultValue = "") String keyword,@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size){
	return this.offerService.getListOffer(searcher,city, categorie, keyword,page,size);
}
@GetMapping("/byUser")
public List<Offer> getOffersByUser(String username,@RequestParam(defaultValue = "") String keyword){
	return this.offerService.getOffersByUser(username, keyword);
}

@PostMapping("/add")
public Offer addOffer(@RequestBody OfferRequest request){
	return this.offerService.add(request);
}

@PostMapping("/addProposal")
public Offer addOffer(@RequestBody ProposalRequest request){
	return this.offerService.addProposal(request);
}
@PutMapping("/updateProposal")
public Offer updateOffer(@RequestBody ProposalRequest request){
	return this.offerService.updateProposal(request);
}

@GetMapping("/getProposales")
public List<ProposalWithOfferResponse> getProposales(@RequestParam(defaultValue = "") String username){
	return this.offerService.getProposales(username);
}

@DeleteMapping("/deleteProposal/{id}")
public void deleteOffer(@PathVariable Long id){
	 this.offerService.deleteProposal(id);
}


}
