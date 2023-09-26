package letapp.dev.mokayada;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import letapp.dev.mokayada.dao.AppRoleRepository;
import letapp.dev.mokayada.dao.AppUserRepository;
import letapp.dev.mokayada.dao.ItemRepository;
import letapp.dev.mokayada.dao.OfferRepository;
import letapp.dev.mokayada.entities.AppRole;
import letapp.dev.mokayada.entities.AppUser;
import letapp.dev.mokayada.entities.Item;
import letapp.dev.mokayada.entities.Offer;

@SpringBootApplication
public class MokayadaApplication implements CommandLineRunner {
	@Autowired
	private AppRoleRepository appRoleRepository;

	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private OfferRepository offerRepository;

	public static void main(String[] args) {
		SpringApplication.run(MokayadaApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Arrays.asList(new AppRole("USER"), new AppRole("ADMIN"))
		.forEach(e -> this.appRoleRepository.save(e));
		
		Arrays.asList(new Item("Montre","montre casio","neuve",null),
				new Item("telephone","galaxy","neuve",null)).forEach(e->this.itemRepository.save(e));
		Arrays.asList(new AppUser("red5",this.appRoleRepository.findById(1L).get()))
		.forEach(e->this.appUserRepository.save(e));
		Arrays.asList(
				new Offer("extensil de cuisine","bien entretenue","neuf","Fes","maison",null,this.appUserRepository.findById(1L).get()),
		new Offer("Vetements neuf","de mode","neuf","Casablanca","maison",null,this.appUserRepository.findById(1L).get()),
		new Offer("accessoir voiture","de marque","neuf","Rabat","voiture",null,this.appUserRepository.findById(1L).get()),
		new Offer("livres literraure","literature","tanger","Casablanca","maison",null,this.appUserRepository.findById(1L).get())
		)
		.forEach(e->this.offerRepository.save(e));
		
		
	}

}
