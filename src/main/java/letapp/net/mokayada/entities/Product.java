package letapp.net.mokayada.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String descrition;
	private Date creationDate;
	private Date updateDate;
	@OneToMany
	private List<AppPhoto> photos;
}
