package tn.esprit.spring.wecare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.wecare.entities.User;
import tn.esprit.spring.wecare.iservices.IUserService;
import tn.esprit.spring.wecare.repositories.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepo;
	@Override
	public User addUser(User u) {
		return userRepo.save(u);
	}

	@Override
	public User updateUser(User u) {
		return this.userRepo.save(u);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepo.getById(id);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepo.deleteById(id);
		
	}

}
