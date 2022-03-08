package tn.esprit.spring.wecare.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import tn.esprit.spring.wecare.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.esprit.spring.wecare.repositories.UserRepository;




@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;
	


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//      User user = userRepository.findByUserName(username);
//        System.out.println(username);
//        System.out.println("testestestesttest");
//
//        final List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(user.getRole()));
//
//        return  new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
//    }
    
    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User user = userRepository.findByUserName(username);
		if (user == null) throw new UsernameNotFoundException(username);
		
		return new  org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), true,true,
				true, true,
				new ArrayList<>());
		
		//return new User(userEntity.getEmail(), userEntity.getEncryptedPaswword() , new ArrayList<>());
	}

}
