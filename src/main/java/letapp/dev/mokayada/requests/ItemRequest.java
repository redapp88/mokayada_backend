package letapp.dev.mokayada.requests;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {

	
	private String title;
	private String description;
	private String status;
	//private List<Long> photoIds;
	private String username;
}
