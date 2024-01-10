package letapp.dev.mokayada.responses;

import java.util.List;

import letapp.dev.mokayada.entities.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemsListsResponse {
private List<Item> availableItems;
private List<Item> offerItems;
}
