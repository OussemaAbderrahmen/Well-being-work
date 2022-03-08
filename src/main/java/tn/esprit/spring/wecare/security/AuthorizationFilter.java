package tn.esprit.spring.wecare.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;
import tn.esprit.spring.wecare.SpringApplicationContext;
import tn.esprit.spring.wecare.entities.User;
import tn.esprit.spring.wecare.iservices.IUserService;
import tn.esprit.spring.wecare.repositories.UserRepository;
import tn.esprit.spring.wecare.services.UserServiceImpl;

public class AuthorizationFilter extends BasicAuthenticationFilter{

	public AuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
		// TODO Auto-generated constructor stub
	}




	@Override
	protected void doFilterInternal(HttpServletRequest req,
			HttpServletResponse res,
			FilterChain chain)throws IOException,ServletException {
		String header = req.getHeader(SecurityConstants.HEADER_STRING); //copy token eli jeya mel header

		if(header==null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)){
			chain.doFilter(req, res);
			return;
		}
		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req) {
		String token =req.getHeader(SecurityConstants.HEADER_STRING);
		if(token != null) {
			token = token.replace(SecurityConstants.TOKEN_PREFIX, ""); //tna7i bearer

			String user = Jwts.parser()
					.setSigningKey(SecurityConstants.TOKEN_SECRET) //parse token , decripted , get details user (email)
					.parseClaimsJws(token)
					.getBody()
					.getSubject();
																										//khater authenticationfilter mahich bean donc manjmou autowirdiw chay
			/*UserServiceImpl userService = (UserServiceImpl)SpringApplicationContext.getBean("userServiceImpl"); 
			UserRepository userepo = (UserRepository)SpringApplicationContext.getBean("userRepository");// nestaamlou springapplicationcontext bch njmou njibou userimpl bean bch njmou nkharjou user details
			User user1 = userService.getUser(user);
			int x = user1.getNbconnexion();
			user1.setNbconnexion(x+1);
			userepo.save(user1);
			*/
			
			if (user!=null){
				return new UsernamePasswordAuthenticationToken(user,null,new ArrayList<>());
			}
		}
		return null;
	}

}
