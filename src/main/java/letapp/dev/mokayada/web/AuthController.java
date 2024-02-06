package letapp.dev.mokayada.web;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import letapp.dev.mokayada.entities.AppUser;
import letapp.dev.mokayada.requests.AppUserSubscibeRequest;
import letapp.dev.mokayada.requests.AuthenticationRequest;
import letapp.dev.mokayada.security.ExtendedUser;
import letapp.dev.mokayada.security.JwtUtils;
import letapp.dev.mokayada.security.SecurityConstants;
import letapp.dev.mokayada.services.AppUsersService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthenticationManager authenticationManager;

	private final AppUsersService appUsersService;

	private final JwtUtils jwtUtils;

	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request, HttpServletResponse response)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
					request.getPassword(), new ArrayList<>()));
			ExtendedUser user = (ExtendedUser) appUsersService.loadUserByUsername(request.getUsername());

			// System.out.println(user.toString());
			if (user != null) {
				String jwt = jwtUtils.generateToken(user);
				// Cookie cookie = new Cookie("jwt", jwt);
				// cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
//cookie.setSecure(true);
				// cookie.setHttpOnly(true);
				// cookie.setPath("/"); // Global
				// response.addCookie(cookie);
				response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + jwt);
				return null;
				// return ResponseEntity.ok(jwt);
			}
			// return ResponseEntity.status(400).body("Error authenticating");

			throw new RuntimeException("Error authenticating");
		} catch (Exception e) {

			System.out.println("///" + e);
			return ResponseEntity.status(400).body("" + e.getMessage());
			// response.
			// response.addHeader("error",e.getMessage());
			// response.sendError(HttpServletResponse.SC_BAD_REQUEST, "message goes here");
			//
			// new RuntimeException("/////" + e.getMessage());
		}
	}

	@PostMapping("/register")
	public String register(@RequestBody AppUserSubscibeRequest userRequest) throws Exception {
		AppUser user = appUsersService.add(userRequest);
	    return "Utilisateur ajouté";
	}
	
	@GetMapping("/getUser")
	public AppUser getUser(@RequestParam String username) throws Exception {
	return this.appUsersService.getUser(username);
	}
	
	@PutMapping("/updateUser")
	public AppUser updateUser(@RequestParam String username,@RequestBody AppUserSubscibeRequest userRequest) throws Exception {
	return this.appUsersService.upDateUser(username,userRequest);
	}

}
