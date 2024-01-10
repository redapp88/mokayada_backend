package letapp.dev.mokayada.requests;

import java.util.List;

import letapp.dev.mokayada.entities.Item;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProposalRequest  {
	private Long offerId;
	private String username;
	private List<Item> items;
}
