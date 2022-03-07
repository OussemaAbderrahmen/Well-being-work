package tn.esprit.spring.wecare.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.wecare.entities.Quizz;
import tn.esprit.spring.wecare.entities.Userdto;

@Repository
public interface QuizRepository extends CrudRepository<Quizz, Long> {
	
	@Query(	value="SELECT first_name, last_name FROM user LEFT JOIN quizz on quizz.user_user_id=user.user_id ORDER BY quizz_result DESC LIMIT 1",
			nativeQuery = true )
	public Userdto Bestscoreforuser();

}
