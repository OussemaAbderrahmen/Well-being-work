package tn.esprit.spring.wecare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.wecare.entities.CommentPost;
@Repository
public interface CommentPostRepository extends JpaRepository<CommentPost, Long> {

}
