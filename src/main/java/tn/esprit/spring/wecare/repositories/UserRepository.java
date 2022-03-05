package tn.esprit.spring.wecare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.wecare.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM User u WHERE  u.FirstName= :name OR u.LastName= :name")
	User findByFirstName(String name);
	
	@Query("SELECT u FROM User u WHERE  u.LastName= :name")
	User findByLastName(String name);


}
