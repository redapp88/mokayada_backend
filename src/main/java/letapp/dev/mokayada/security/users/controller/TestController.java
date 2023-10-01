package letapp.dev.mokayada.security.users.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class TestController {
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

}
