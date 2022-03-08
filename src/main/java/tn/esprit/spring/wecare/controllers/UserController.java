package tn.esprit.spring.wecare.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.wecare.response.ResponseHandler;
import tn.esprit.spring.wecare.entities.User;
import tn.esprit.spring.wecare.repositories.UserRepository;
import tn.esprit.spring.wecare.services.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserServiceImpl userServ;
	@Autowired
	UserRepository userRepo;
	// @Autowired
	// private PasswordEncoder passwordEncoder;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	/*
	 * //http://localhost:8089/wecare/forum/add-user
	 * 
	 * @PostMapping("/add-user") public User addUser(@RequestBody User u) {
	 * 
	 * return userServ.addUser(u); }
	 */

	// http://localhost:8089/wecare/user/add-user
	@PostMapping("/add-user")
	@ResponseBody
	public ResponseEntity<Object> addUser(@RequestBody User u, HttpServletRequest request) {

		User u1 = userRepo.findByUserName(u.getUserName());
		if (u1 == null) {
			System.out.println("test1");
			u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
			u.setActive(true);
			u.setRole("ROLE_ADMIN");
			User user = userServ.addUser(u);
			
			return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, user);
		} else {
			System.out.println("test2");
			return ResponseHandler.generateResponse("UserName already exists", HttpStatus.MULTI_STATUS,
					"UserName already exists");
		}

	}

	// http://localhost:8089/wecare/user/update-user
	@PutMapping("/update-user")
	public User updateUser(@RequestBody User u) {
		return userServ.updateUser(u);
	}

	// http://localhost:8089/wecare/user/get-all-users
	@GetMapping("/get-all-users")
	public List<User> getAll() {
		List<User> listUser = userServ.getAllUser();
		return listUser;
	}

	// http://localhost:8089/wecare/user/get-user-by-id/2
	@GetMapping("/get-user-by-id/{user-id}")
	public User getUserById(@PathVariable("user-id") Long id) {
		User u = userServ.getUserById(id);
		return u;
	}

	// http://localhost:8089/wecare/user/delete-user/2
	@DeleteMapping("/delete-user/{user-id}")
	public void deleteUser(@PathVariable("user-id") Long id) {
		userServ.deleteUserById(id);
	}

	// http://localhost:8089/wecare/user/active-user
	@GetMapping("/active-user")
	public User UserOfTheMonth() {
		return userServ.UserOfTheMonth();
	}

	// http://localhost:8089/wecare/user/statistics
	@GetMapping("/statistics")
	public String StatisticsUser() {
		return userServ.UserStatistics();
	}

}
