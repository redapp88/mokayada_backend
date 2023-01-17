package letapp.net.mokayada.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import letapp.net.mokayada.domaine.OfferVo;
import letapp.net.mokayada.services.OfferService;

@RestController
@RequestMapping("offers")
public class OfferController {
	@Autowired
	private OfferService offerService;

	@GetMapping("/find")
	public List<OfferVo> findByKeyword(@RequestParam String keyword) {
		return this.offerService.findOffersByKeyword(keyword);
	}

}
