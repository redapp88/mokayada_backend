package letapp.dev.mokayada;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import letapp.dev.mokayada.dao.AppPhotosRepository;
import letapp.dev.mokayada.dao.AppRoleRepository;
import letapp.dev.mokayada.dao.AppUserRepository;
import letapp.dev.mokayada.dao.ItemRepository;
import letapp.dev.mokayada.dao.OfferRepository;
import letapp.dev.mokayada.entities.AppPhoto;
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
	@Autowired
	private AppPhotosRepository appPhotosRepository;

	public static void main(String[] args) {
		SpringApplication.run(MokayadaApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Arrays.asList(new AppRole("USER"), new AppRole("ADMIN")) .forEach(e ->
		 * this.appRoleRepository.save(e)); Arrays.asList(new
		 * AppUser("red5",this.appRoleRepository.findById(1L).get()))
		 * .forEach(e->this.appUserRepository.save(e));
		 * 
		 * Arrays.asList(new
		 * Item("Montre","montre casio","neuve",null,appUserRepository.findById("red5").
		 * get( )), new
		 * Item("telephone","galaxy","neuve",null,appUserRepository.findById("red5").get
		 * ())) .forEach(e->this.itemRepository.save(e));
		 * 
		 * Arrays.asList( new AppPhoto("photo1",
		 * "https://st4.depositphotos.com/14431644/22076/i/450/depositphotos_220767694-stock-photo-handwriting-text-writing-example-concept.jpg"
		 * ,this.itemRepository.findById(1L).get()), new AppPhoto("photo2",
		 * "https://www.shutterstock.com/shutterstock/photos/2125644341/display_1500/stock-photo-the-word-example-is-written-on-a-magnifying-glass-on-a-yellow-background-2125644341.jpg"
		 * ,this.itemRepository.findById(1L).get())
		 * ).forEach(e->this.appPhotosRepository.save(e));
		 * 
		 * 
		 * 
		 * Arrays.asList( new
		 * Offer("extensil de cuisine","bien entretenue","neuf","Fes","maison",null,this
		 * .appUserRepository.findById("red5").get()), new
		 * Offer("Vetements neuf","de mode","neuf","Casablanca","maison",null,this.
		 * appUserRepository.findById("red5").get()), new
		 * Offer("accessoir voiture","de marque","neuf","Rabat","voiture",null,this.
		 * appUserRepository.findById("red5").get()), new
		 * Offer("livres literraure","literature","tanger","Casablanca","maison",null,
		 * this.appUserRepository.findById("red5").get()) ) .forEach(e->{
		 * this.offerRepository.save(e);
		 * 
		 * ;});
		 * this.offerRepository.findAll().forEach(e->{e.setItems(this.itemRepository.
		 * findAll());System.out.println(e.getItems().size());
		 * e.getItems().forEach(i->e.getItems().add(i));});
		 */
		
		
	}

}
