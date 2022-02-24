package tn.esprit.spring.wecare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.wecare.entities.User;
import tn.esprit.spring.wecare.services.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserServiceImpl userServ;

	//http://localhost:8089/wecare/user/add-user
		@PostMapping("/add-user") 
		public User addUser(@RequestBody User u)
		 {
			
			return userServ.addUser(u);
		}
		//http://localhost:8089/wecare/user/update-user
		@PutMapping("/update-user")
		public User updateUser(@RequestBody User u){
		
			userServ.updateUser(u);
			return u;
		}
		//http://localhost:8089/wecare/user/get-all-users
		@GetMapping("/get-all-users")
		public List<User> getAll(){
			List<User> listUser = userServ.getAllUser();
			return listUser;
		}
		
		//http://localhost:8089/wecare/user/get-user-by-id/2
		@GetMapping("/get-user-by-id/{user-id}")
		public User getUserById(@PathVariable("user-id") Long id){
			User u = userServ.getUserById(id);
			return u;
		}
		//http://localhost:8089/wecare/user/delete-user/2
		@DeleteMapping("/delete-user/{user-id}")
		public void deleteUser(@PathVariable("user-id")Long id) {
			userServ.deleteUserById(id);
		}
		
		
			
			



}
