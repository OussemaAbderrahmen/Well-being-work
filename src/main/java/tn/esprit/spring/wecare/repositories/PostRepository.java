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
	@Query("from Posts p order by p.DatePost desc")
    List<Posts> findAllSortedByDateReverse();

   // Posts findFirstByOrderByIdDesc();

   /* @Query("from Posts p order by p.DatePost desc")
    Page<Posts> findAll(final Pageable pageable);*/
}
