package tn.esprit.spring.wecare.repositories;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.wecare.entities.Posts;
@Repository
public interface PostRepository extends JpaRepository<Posts, Long> {

}
