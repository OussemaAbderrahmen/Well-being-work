package tn.esprit.spring.wecare.authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.wecare.authentication.AuthenticationRequest;
import tn.esprit.spring.wecare.response.ResponseHandler;
import tn.esprit.spring.wecare.services.MyUserDetailsService;
import tn.esprit.spring.wecare.utils.JwtUtil;
//@RestController
public class AuthenticationEndPoint {}
//	
//	@Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private MyUserDetailsService myUserDetailsService;
//
//    @Autowired
//    private JwtUtil jwtTokenUtil;
//
//
//    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
//            );
//        }catch (BadCredentialsException e){
//            return ResponseHandler.generateResponse("userName or Password incorrect", HttpStatus.NOT_FOUND, "User not found");
//        }
//        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//
//        final String jwt = jwtTokenUtil.generateToken(userDetails);
//
//        return ResponseHandler.generateResponse("authenticated!", HttpStatus.OK, jwt);
//    }
//
//}
