package letapp.dev.mokayada;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import letapp.dev.mokayada.dao.AppUserRepository;
import letapp.dev.mokayada.dao.OfferRepository;
import letapp.dev.mokayada.entities.AppRole;
import letapp.dev.mokayada.entities.AppUser;
import letapp.dev.mokayada.entities.Item;
import letapp.dev.mokayada.entities.Offer;
import letapp.dev.mokayada.requests.OfferRequest;
import letapp.dev.mokayada.services.OfferService;

@SpringBootTest
class MokayadaApplicationTests {
	@Autowired
	private OfferService offerService;

	@MockBean
	private OfferRepository offerRepository;
	@MockBean
	private AppUserRepository appUserRepository;

	@Test
	public void getListOfferTest() {
		List<Offer> offers = Stream.of(new Offer(), new Offer(), new Offer()).collect(Collectors.toList());

		Page<Offer> offersPage = new PageImpl<Offer>(offers, PageRequest.of(0, 5), offers.size());
		when(offerRepository.getOffers("searcher", "%city%", "%categorie%", "%keyword%", PageRequest.of(1, 5)))
				.thenReturn(offersPage);

		assertEquals(3, offerService.getListOffer("searcher", "city", "categorie", "keyword", 1, 5).getTotalElements());
	}

	@Test
	public void getOfferTest() {
		Offer offer = new Offer(1L, new Date(), "Offer title", "Offer description", "Offer Status", "Offer Status",
				"Offer Categorie", null, new ArrayList<Offer>(), null, new ArrayList<Item>());

		when(offerRepository.findById(1L)).thenReturn(Optional.of(offer));
		assertEquals(1L, offerService.getOffer(1L).getId().longValue());
	}

	@Test
	public void getListOffer2Test() {
		List<Offer> offers = Stream.of(new Offer(), new Offer(), new Offer()).collect(Collectors.toList());

		Page<Offer> offersPage = new PageImpl<Offer>(offers, PageRequest.of(0, 5), offers.size());
		when(offerRepository.getOffers(1L, PageRequest.of(1, 5))).thenReturn(offersPage);

		assertEquals(3, offerService.getListOffer(1L, 1, 5).getTotalElements());

	}

	@Test
	public void getOffersByUserTest() {
		List<Offer> offers = Stream.of(new Offer(), new Offer(), new Offer()).collect(Collectors.toList());

		when(offerRepository.getOffersByUser("username", "%keyword%")).thenReturn(offers);

		assertEquals(3, offerService.getOffersByUser("username", "keyword").size());
	}

	@Test
	void addOfferTest() {
		Optional<AppUser> userOpt = Optional.of(new AppUser("username", "firstname", "lastname", "male", "0707070707", "mail@mail.com",
				new Date(), new Date(), "password", "state", new AppRole()));
		OfferRequest offerRequest = new OfferRequest("Offer title", "Offer description", "Offer Categorie",
				"Offer city", "username");
		
		Offer offer = new Offer( offerRequest.getTitle(), offerRequest.getDescription(), "FREE", offerRequest.getCity(),
				offerRequest.getCategorie(), null, userOpt.get());
		offer.setId(1L);
		System.out.println(offerRequest);
		System.out.println(offer);
		
		when(this.offerRepository.save(offer)).thenReturn(offer);
		when(this.appUserRepository.findByUsername("username")).thenReturn(userOpt);
		
		assertEquals(offer.getTitle(), this.offerService.add(offerRequest).getTitle());
	}

	@Test
	void contextLoads() {
	}

}
