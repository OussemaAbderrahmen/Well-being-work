package tn.esprit.spring.wecare.iservices;


import java.util.List;

import tn.esprit.spring.wecare.entities.BestAndWorstPost;
import tn.esprit.spring.wecare.entities.Posts;

public interface IPostservice {

	public Posts createPost(Posts p);
	public Posts createPostAndAffectToUser(Posts p,Long userId);
	public Posts updatePost(Posts p,Long id);
	public List<Posts> getAllPosts();
	public Posts getPostById(Long id);
	public void deletePostById(Long id);
	public void likeAPost(Long idPost , Long id);
	public void dislikeAPost(Long idPost, Long id );
	public BestAndWorstPost bestPost();
	public BestAndWorstPost worstPost();
}
