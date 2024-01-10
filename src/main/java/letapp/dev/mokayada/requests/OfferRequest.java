package letapp.dev.mokayada.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OfferRequest {

	private String title;
	private String description;
	private String categorie;
	private String city;
	private String username;
}
