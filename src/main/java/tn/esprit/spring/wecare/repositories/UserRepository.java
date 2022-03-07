package tn.esprit.spring.wecare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.wecare.entities.MostDynamicUser;
import tn.esprit.spring.wecare.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	/*@Query(value = "SELECT first_name , user.last_name  , COUNT( posts.post_id ) postreact "
			+ "FROM user  LEFT JOIN posts ON user.user_id = posts.user_user_id  "
			+ "GROUP BY(user.user_id) "
			+ "ORDER BY postreact "
			+ "DESC LIMIT 1"  , nativeQuery = true)*/
	
	@Query(value="SELECT user.first_name as name,COUNT(posts.post_id) postreact "
			+ "FROM user LEFT JOIN posts ON user_user_id = posts.user_user_id"
			+ " where Month(posts.date_post) = Month(CURRENT_DATE)"
			+ " GROUP BY(user_user_id) "
			+ "ORDER BY  postreact "
			+ "DESC LIMIT 1",nativeQuery=true)
	public MostDynamicUser mostDynamicUser(); 
	
	
	@Query("SELECT u FROM User u WHERE  u.firstName= :name OR u.lastName= :name")
	User findByFirstName(String name);
	
	@Query("SELECT u FROM User u WHERE  u.lastName= :name")
	User findByLastName(String name);
	
}

