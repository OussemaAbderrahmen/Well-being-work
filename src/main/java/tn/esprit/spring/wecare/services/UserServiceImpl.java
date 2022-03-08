package tn.esprit.spring.wecare.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.wecare.entities.Connection;
import tn.esprit.spring.wecare.entities.MostDynamicUser;
import tn.esprit.spring.wecare.entities.User;
import tn.esprit.spring.wecare.iservices.IUserService;
import tn.esprit.spring.wecare.repositories.ConnectionRepository;
import tn.esprit.spring.wecare.repositories.UserRepository;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepo;
	@Autowired
	ConnectionRepository conrepo;
	
	@Autowired
	EmailSenderService eService;

	@Override
	public User addUser(User u) {
		
		eService.sendSimpleEmail(u.getEmail(), "*** Welcome to WeCare ***\n" + "Your Username :    "
					+ u.getUserName() + "\nYour Password :    " + u.getPassword(), "Welcome To WeCare");
		return userRepo.save(u);
	}

	@Override
	public User updateUser(User u) {
		return userRepo.save(u);
	}


	@Override
	public User getUserById(Long id) {
		return userRepo.getById(id);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepo.deleteById(id);
	}

	@Override
	public User findUserByUserName(String username) {
		return userRepo.findByUserName(username);
	}

	@Override
	public User BlocUser(User u) {
		int x = u.getWarningNum();
		if (x > 3) {
			u.setLocked(true);
			return userRepo.save(u);
		} else
			return userRepo.save(u);
	}



	@Override
	public List<User> getAllUser() {
			return userRepo.findAll();
	}

	

	@Override
	public User getUser(String username) {
		return userRepo.findByUserName(username);
	}

	

	@Override
	public String UserStatistics() {
		List<User> l = userRepo.findAll();
		double x = l.size();
		double b = 0;
		double notb = 0;
		for (User u : l) {
			if (u.getLocked()) {
				b++;
			} else if (u.getLocked() == false) {
				notb++;
			}
		}
		log.info("b" + b);
		log.info("notb" + notb);
		double sb = (b / x) * 100;
		double snotb = (notb / x) * 100;
		log.info("sb" + sb);
		log.info("snotb" + snotb);
		return "Blocked Users : " + sb + "% \nUnblocked Users : " + snotb + "%";
	}

	@Override
	public User UserOfTheMonth() {
		Date d =new Date();
		int nbc = 0;
		List<User> lu = userRepo.findAll();
		List<Connection> lc = conrepo.findAll();
		for (User u : lu) {
			for (Connection c : lc) {
				log.info("date de connexion "+c.getDateconnexion());
				if (c.getUsername() == u.getUserName()) {
					if (c.getDateconnexion().getMonth() == 12 && d.getMonth() == 1 && d.getYear()-c.getDateconnexion().getYear()==1) {
						nbc++;
					}
					else if (c.getDateconnexion().getMonth() == d.getMonth() - 1 ) {	
						nbc++;
					}
				}
				u.setNbconnexion(nbc);
				userRepo.save(u);
			}	
		}	
		
		User x =new User();
		for(User u : userRepo.findAll()){
			if(u.getNbconnexion()>x.getNbconnexion()){
				x=u;
			}			
		}
		return x ;	
	}

	

	








	
}
