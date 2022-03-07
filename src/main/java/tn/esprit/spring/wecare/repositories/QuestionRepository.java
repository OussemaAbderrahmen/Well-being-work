package tn.esprit.spring.wecare.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.wecare.entities.Questions;

@Repository
public interface QuestionRepository extends CrudRepository<Questions, Long> {

}
