package letapp.dev.mokayada.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Offer implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date creationDate;
	private String title;
	private String description;
	private String status;
	private String city;
	private String categorie;
	@JsonIgnore
	@ManyToOne()
	private Offer parentOffer;
	
	@OneToMany()
	private List<Offer> propositions;

	@ManyToOne()
	private AppUser owner;

	@ManyToMany()
	private List<Item> items;

	public Offer(String title, String description, String status, String city, String categorie, Offer parentOffer,
			AppUser owner) {
		super();
		this.creationDate = new Date();
		this.title = title;
		this.description = description;
		this.status = status;
		this.parentOffer = parentOffer;
		this.owner = owner;
		this.city = city;
		this.categorie = categorie;
		this.propositions = new ArrayList<Offer>();
		this.items = new ArrayList<Item>();
	}

	@Override
	public boolean equals(Object obj) {
	return ((Offer)obj).id.equals(this.id);
	}

	
}
