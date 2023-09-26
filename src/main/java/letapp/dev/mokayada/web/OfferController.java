package letapp.dev.mokayada.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import letapp.dev.mokayada.entities.Offer;
import letapp.dev.mokayada.services.OfferService;

@RestController
@RequestMapping("/offers")
public class OfferController {
	@Autowired
	private OfferService offerService;
@GetMapping()
public Offer getOffer(@RequestParam Long id) {
	return this.offerService.getOffer(id);
}
@GetMapping("/byParams")
public Page<Offer> getOffers(@RequestParam(defaultValue = "*") String city,@RequestParam(defaultValue = "*") String categorie,@RequestParam(defaultValue = "") String keyword,@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size){
	return this.offerService.getListOffer(city, categorie, keyword,page,size);
}
@GetMapping("/byUser")
public Page<Offer> getOffers(@PathVariable Long user_id,@RequestParam int page,@RequestParam int size ){
	return this.offerService.getListOffer(user_id,page,size);
}

}
