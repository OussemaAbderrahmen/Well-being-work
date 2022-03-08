package tn.esprit.spring.wecare.authentication;

public class AuthenticationResponse {

	   private String jwt;

	    public AuthenticationResponse(String jwt) {

	    }

	    public void setJwt(String jwt) {
	        this.jwt = jwt;
	    }

	    public String getJwt() {
	        return jwt;
	    }
	}
