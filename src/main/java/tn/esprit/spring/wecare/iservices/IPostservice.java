package tn.esprit.spring.wecare.iservices;

import java.util.List;

import tn.esprit.spring.wecare.entities.Posts;

public interface IPostservice {

	public Posts createPost(Posts p);
	public Posts updatePost(Posts p);
	public List<Posts> getAllPosts();
	public Posts getPostById(Long id);
	public void deletePostById(Long id);
}
