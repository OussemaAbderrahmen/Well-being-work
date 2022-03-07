package tn.esprit.spring.wecare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.wecare.entities.PublicationComments;

@Repository
public interface PublicationCommentsRepository extends JpaRepository<PublicationComments, Long> {
	
	@Query("from PublicationComments pc order by pc.CommentDate desc")
	List<PublicationComments> findAllByDate(Long id);

}
