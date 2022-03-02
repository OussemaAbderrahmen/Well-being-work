package tn.esprit.spring.wecare.repositories;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.wecare.entities.BestAndWorstPost;
import tn.esprit.spring.wecare.entities.Posts;
import java.lang.String;
@Repository
public interface PostRepository extends JpaRepository<Posts, Long> {
	@Query("from Posts p order by p.DatePost desc")
    List<Posts> findAllSortedByDateReverse();
	
	
	
	
	@Query( value="SELECT posts.title_post AS name , COUNT( posts_user_likes.posts_post_id) occ FROM posts_user_likes"
			+ "  LEFT JOIN posts ON posts.post_id=posts_user_likes.posts_post_id"
			+ " GROUP BY(posts_post_id) "
			+ "ORDER BY  occ "
			+ "DESC LIMIT 1", nativeQuery=true)
	public BestAndWorstPost bestPost();
	
	@Query(value="SELECT posts.title_post AS name , COUNT( posts_user_dislikes.posts_post_id) occ FROM posts_user_dislikes "
			+ "LEFT JOIN posts ON posts.post_id=posts_user_dislikes.posts_post_id "
			+ "GROUP BY(posts_post_id)"
			+ " ORDER BY  occ "
			+ "DESC LIMIT 1",nativeQuery=true)
	public BestAndWorstPost worstPost();
	


   // Posts findFirstByOrderByIdDesc();

   /* @Query("from Posts p order by p.DatePost desc")
    Page<Posts> findAll(final Pageable pageable);*/
}
