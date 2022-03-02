package tn.esprit.spring.wecare.repositories;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.wecare.dto.UserPosts;
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
	

	@Query(value = "SELECT posts.description_post , posts.title_post , user.first_name  "
			+ "FROM posts LEFT JOIN user ON posts.user_user_id=user.user_id"
			+ " WHERE first_name= :name"  , nativeQuery = true)
	public List<UserPosts> PostbyName(@Param("name")String name); 

   // Posts findFirstByOrderByIdDesc();

   /* @Query("from Posts p order by p.DatePost desc")
    Page<Posts> findAll(final Pageable pageable);*/
}
