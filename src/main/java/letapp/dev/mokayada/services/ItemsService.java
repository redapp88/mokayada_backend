package letapp.dev.mokayada.services;

import java.util.List;

import org.springframework.data.domain.Page;

import letapp.dev.mokayada.entities.Item;
import letapp.dev.mokayada.requests.ItemRequest;

public interface ItemsService {

	public Page<Item> getListItems(String username, int page, int size);

	public Item addItem(ItemRequest request);

	public Item updateItem(Long id, ItemRequest request);

	public void delete(Long id);

	public Item getItem(Long id);
	

}
