package letapp.dev.mokayada.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

}
