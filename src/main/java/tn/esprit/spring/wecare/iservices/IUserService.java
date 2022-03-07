package tn.esprit.spring.wecare.iservices;

import java.util.List;
import tn.esprit.spring.wecare.entities.User;

public interface IUserService {
	
	public User addUser(User u);
	public User updateUser(User u);
	public List<User> getAllUser();
	public User getUserById(Long id);
	public void deleteUserById(Long id);
	/*public User findUserByUserName(String username);
	public User getUser(String username);
	public User BlocUser(User u );
	public void sendSimpleEmail(String toEmail,
			                    String body,
			                    String subject);
		
	public String UserStatistics();*/

}
