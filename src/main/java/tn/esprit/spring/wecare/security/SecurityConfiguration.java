package tn.esprit.spring.wecare.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import tn.esprit.spring.wecare.services.MyUserDetailsService;



@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private final MyUserDetailsService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public SecurityConfiguration(MyUserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userDetailsService = userDetailsService;
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST , "/user/add-user")
		.permitAll()
		//.antMatchers(HttpMethod.POST , //url)
		//.permitAll()
		.anyRequest().authenticated() //sign up authorized be9i lkol le
		.and()
		.addFilter(getAuthenticationFilter())
		.addFilter(new AuthorizationFilter(authenticationManager())) //lkool lezem iconectiw ken sign up
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // bch nkoulou l spring security eli rest api te3na lezem ikounou stateless
				// maghir matsir http session
	
	
	}
	
		@Override
		public void configure (AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder); //tkolou anehi interface taa service eli theb testaamlha o bch tnjm taaml authentication
		}
		
		public AuthenticationFilter getAuthenticationFilter() throws Exception {
			final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
			filter.setFilterProcessesUrl("/user/login");
			return filter;
		}  //bch tbadel url taa login
	
	
	
	
	
	
	
	
	
	
	
//	@Autowired
//	DataSource dataSource;
//	@Autowired
//	private MyUserDetailsService myUserDetailsService;
//	@Autowired
//	JwtRequestFilter jwtRequestFilter;
//
//	//Create rules that require authentication for all endpoints except /registration
//	@Override
//	 protected void configure(HttpSecurity httpSecurity) throws Exception {
//		 //httpSecurity.csrf().disable();
//		;
//		  httpSecurity.csrf().disable().cors().disable()
//				  .authorizeRequests()
//				  .antMatchers("/user/**").hasRole("ADMIN")
//				  //.antMatchers("/client/user","/client/user/**").hasAnyRole("USER", "ADMIN")
//				  //.antMatchers("/client/entreprise","/client/entreprise/**").hasAnyRole("ENTREPRISE", "ADMIN")
//				  //.antMatchers("/client/employee","/client/employee/**").hasAnyRole("EMPLOYEE","ENTREPRISE", "ADMIN")
//				  .antMatchers("/authenticate","/**").permitAll()
//				  .anyRequest().authenticated()
//				  //.antMatchers("/**").permitAll()
//				  //.and().formLogin();
//				  .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//		  httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		//Using JWT
//		auth.userDetailsService(myUserDetailsService)
//				.passwordEncoder(passwordEncoder());
//
//		//using JDBC
////		auth.jdbcAuthentication()
////				.dataSource(dataSource)
////				.passwordEncoder(passwordEncoder())
////				.usersByUsernameQuery("select nom,password,enabled " +
////						"from client " +
////						"where nom = ? ")
////				.authoritiesByUsernameQuery("select nom,role " +
////						"from client " +
////						"where nom = ? ");
//	}
//
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManager() throws Exception {
//		return super.authenticationManager();
//	}
//
//	 //Crypting password
//	 @Bean
//	  public PasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder();
//		// return NoOpPasswordEncoder.getInstance();
//	  }
	  
}
