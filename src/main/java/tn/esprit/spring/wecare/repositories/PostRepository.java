package tn.esprit.spring.wecare.repositories;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.wecare.dto.UserPosts;
import tn.esprit.spring.wecare.entities.BestAndWorstPost;
import tn.esprit.spring.wecare.entities.MostDynamicUser;
import tn.esprit.spring.wecare.entities.Posts;
import tn.esprit.spring.wecare.entities.Publication;
import tn.esprit.spring.wecare.entities.User;

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
	public List<UserPosts> postbyFirstName(@Param("name")String name);
	
	
	@Query(value="SELECT posts.description_post , posts.title_post , user.first_name "
			+ "FROM posts LEFT JOIN user ON posts.user_user_id=user.user_id "
			+ "WHERE title_post= :name ",nativeQuery=true)
	public List<UserPosts> postByTitle(@Param("name")String name);
	
	@Query(value="SELECT posts.description_post , posts.title_post , user.first_name "
			+ "FROM posts LEFT JOIN user ON posts.user_user_id=user.user_id "
			+ "WHERE description_post= :name ",nativeQuery=true)
	public List<UserPosts> postByDescription(@Param("name")String name);
	
	
	
	
	@Query(value="SELECT first_name as name,COUNT(posts.post_id) postreact "
			+ "FROM user LEFT JOIN posts ON user_user_id = posts.user_user_id"
			+ " where Month(posts.date_post) = Month(CURRENT_DATE)"
			+ " GROUP BY(user_user_id) "
			+ "ORDER BY  postreact "
			+ "DESC LIMIT 1",nativeQuery=true)
	public MostDynamicUser mostDynamicUser(); 
	


	@Query( value="SELECT posts.title_post AS name, COUNT( posts_user_likes.posts_post_id) occ"
			+ " FROM posts_user_likes LEFT JOIN posts ON posts.post_id = posts_user_likes.posts_post_id "
			+ "where Month(posts.date_post) = Month(CURRENT_DATE) "
			+ "GROUP BY(post_id) "
			+ "ORDER BY  occ "
			+ "DESC LIMIT 3", nativeQuery=true)
	public List<BestAndWorstPost> bestPostsByMonth();

   /* @Query("from Posts p order by p.DatePost desc")
    Page<Posts> findAll(final Pageable pageable);*/
}
