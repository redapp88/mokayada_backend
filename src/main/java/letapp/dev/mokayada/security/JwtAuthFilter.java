package letapp.dev.mokayada.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
			throws ServletException, java.io.IOException {

	response.addHeader("Access-Control-Allow-Origin", "*");
	response.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
	response.addHeader("Access-Control-Allow-Headers","Origin, Accept, X-requested-With, "
			+ "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,"
			+ "Authorization");
	response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin,"
			+ "Access-Control-Allow-Credentials, Authorization");
	
	if(request.getMethod().equals("OPTIONS")) {
		response.setStatus(HttpServletResponse.SC_OK);
	}

	else {
	String jwt=request.getHeader(SecurityConstants.HEADER_STRING);

	if(jwt==null || !jwt.startsWith(SecurityConstants.TOKEN_PREFIX)){
		filterChain.doFilter(request, response); return;
	}
	Claims claims=Jwts.parser()
			.setSigningKey(SecurityConstants.SECRET)
			.parseClaimsJws(jwt.replace(SecurityConstants.TOKEN_PREFIX, ""))
			.getBody();
	String username=claims.getSubject();
	ArrayList<Map<String,String>> roles=(ArrayList<Map<String,String>>)claims.get("authorities");
	Collection<GrantedAuthority> authorities= new ArrayList<>();
	roles.forEach(r->{
		authorities.add(new SimpleGrantedAuthority(r.get("authority")));
	});
	UsernamePasswordAuthenticationToken authentificatedUser=
			new UsernamePasswordAuthenticationToken(username,null, authorities);
	SecurityContextHolder.getContext().setAuthentication(authentificatedUser);
	filterChain.doFilter(request, response);
			
	}
}}
