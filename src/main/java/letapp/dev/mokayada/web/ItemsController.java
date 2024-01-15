package letapp.dev.mokayada.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import letapp.dev.mokayada.entities.Item;
import letapp.dev.mokayada.requests.ItemRequest;
import letapp.dev.mokayada.requests.OfferWithItemsRequest;
import letapp.dev.mokayada.responses.ItemsListsResponse;
import letapp.dev.mokayada.services.ItemsService;

@RestController
@RequestMapping("/api/v1/items")

public class ItemsController {
	@Autowired
	private ItemsService itemsService;

	@GetMapping("/byParams")
	public Page<Item> getItems(@RequestParam String username,@RequestParam int page,@RequestParam int size) {
		return this.itemsService.getListItems(username, page, size);
	}
	@GetMapping("/getOne")
	public Item getItem(@RequestParam Long id) {
		return this.itemsService.getItem(id);
	}

	@PostMapping("/add")
	public Item addItem(@RequestBody ItemRequest request) {
		return this.itemsService.addItem(request);
	}
	
	@PostMapping("/saveToOffer")
	public void saveItemsToOffer(@RequestParam Long offerId,@RequestBody OfferWithItemsRequest offerWithItemsRequest) {
		 this.itemsService.saveItemsToOffer(offerId,offerWithItemsRequest);
	}

	@PutMapping("/update/{id}")
	public Item updateItem(@PathVariable Long  id,@RequestBody  ItemRequest request) {
		return this.itemsService.updateItem(id,  request);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteItem(@PathVariable Long id) {
		  this.itemsService.delete(id);
	}
	@GetMapping("/byOffer")
	public ItemsListsResponse geItemsByOffer(@RequestParam String username,@RequestParam Long offerId) {
		return this.itemsService.getItemsByOffer(username,offerId);
		
		
	}
	@GetMapping("/byUser")
	public List<Item> geItemsUser(@RequestParam String username) {
		return this.itemsService.getItemsByUser(username);
		
		
	}


}
