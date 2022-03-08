package tn.esprit.spring.wecare.iservices;

import java.util.List;
import tn.esprit.spring.wecare.entities.User;

public interface IUserService {
	
	public User addUser(User u);
	public User updateUser(User u);
	public User findUserByUserName(String username);
	public List<User> getAllUser();
	public User getUserById(Long id);
	public User getUser(String username);
	public void deleteUserById(Long id);
	public User BlocUser(User u );
	//public void sendSimpleEmail2(String toEmail,
	//		                    String body,
	//		                    String subject);
		
	public String UserStatistics();
	public User UserOfTheMonth();

}
