package letapp.dev.mokayada.web;



import java.io.IOException;
import java.util.ArrayList;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request, HttpServletResponse response) throws Exception {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword(),
                            new ArrayList<>()));
             ExtendedUser user = (ExtendedUser) appUsersService.loadUserByUsername(request.getUsername());
             
             //System.out.println(user.toString());
            if (user != null) {
                String jwt = jwtUtils.generateToken(user);
                //Cookie cookie = new Cookie("jwt", jwt);
                //cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
//cookie.setSecure(true);
                //cookie.setHttpOnly(true);
                //cookie.setPath("/"); // Global
                //response.addCookie(cookie);
                response.addHeader(SecurityConstants.HEADER_STRING,
        				SecurityConstants.TOKEN_PREFIX+jwt);
                return null;
                //return ResponseEntity.ok(jwt);
            }
           // return ResponseEntity.status(400).body("Error authenticating");
 
            throw new RuntimeException("Error authenticating");
        } catch (Exception e) {
           
            System.out.println("///"+e);
            return ResponseEntity.status(400).body("" + e.getMessage());
            //response.
            //response.addHeader("error",e.getMessage());
           // response.sendError(HttpServletResponse.SC_BAD_REQUEST, "message goes here");
           //
            // new RuntimeException("/////" + e.getMessage());
        }
    }

	/*
	 * @PostMapping("/register") public ResponseEntity<UserSecurity>
	 * register(@RequestBody UsersRequest user) throws Exception { return
	 * ResponseEntity.ok(authService.AddUser(user).map(UserSecurity::new).
	 * orElseThrow(() -> new Exception("Unknown"))); }
	 */

}
