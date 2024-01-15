package letapp.dev.mokayada.requests;

import java.util.List;

import letapp.dev.mokayada.entities.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OfferWithItemsRequest {
	private OfferRequest offerRequest;
	private List<Item> items;
	

}
