package tn.esprit.spring.wecare.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.wecare.entities.CommentPost;
import tn.esprit.spring.wecare.entities.Posts;
import tn.esprit.spring.wecare.services.CommentPostServiceImpl;
import tn.esprit.spring.wecare.services.PostServiceImpl;

@RestController
@RequestMapping("/forum")
public class ForumController {
	@Autowired
	PostServiceImpl postService;
	@Autowired
	CommentPostServiceImpl commentService;

	// http://localhost:8089/wecare/forum/create-post
	@PostMapping("/create-post")
	public Posts createPost(@RequestBody Posts post) {

		return postService.createPost(post);
	}

	// http://localhost:8089/wecare/forum/update-post/2
	@PutMapping("/update-post/{postId}")
	public Posts updatePost(@RequestBody Posts p , @PathVariable("postId") Long postId) {
		return postService.updatePost(p, postId);
		
	}

	// http://localhost:8089/wecare/forum/get-all-posts
	@GetMapping("/get-all-posts")
	public List<Posts> getAll() {
		List<Posts> listPosts = postService.getAllPosts();
		return listPosts;
	}
	@GetMapping("/get-all-postsSorted")
	public List<Posts> getAllSorted() {
		List<Posts> listPosts = postService.getAllPostSorted();
		return listPosts;
	}

	// http://localhost:8089/wecare/forum/get-post-by-id/2
	@GetMapping("/get-post-by-id/{post-id}")
	public Posts getPostById(@PathVariable("post-id") Long id) {
		Posts p = postService.getPostById(id);
		return p;
	}

	// http://localhost:8089/wecare/forum/delete-post/2
	@DeleteMapping("/delete-post/{post-id}")
	public void deletePost(@PathVariable("post-id") Long id) {
		postService.deletePostById(id);
	}

	// http://localhost:8089/wecare/forum/add-comment/1
	@PostMapping("/add-comment/{idPost}")
	public CommentPost addComment(@RequestBody CommentPost cp, @PathVariable Long idPost) {

		return commentService.createAndAffectCommentToPost(cp, idPost);

	}

	// http://localhost:8089/wecare/forum/retrieve-comments-by-postid/2
	@GetMapping("/retrieve-comments-by-postid/{post-id}")
	public List<CommentPost> retrieveComment(@PathVariable("post-id") Long postId) {
		List<CommentPost> listComment = commentService.getCommentByPostId(postId);
		return listComment;
	}

	// http://localhost:8089/wecare/forum/update-comment/2
	@PutMapping("/update-comment/{comment-id}")
	public CommentPost updateComment(@RequestBody CommentPost cp, @PathVariable("comment-id") Long commentId) {
		return commentService.updateComment(cp, commentId);
		
	}
	
	//http://localhost:8089/wecare/forum/delete-comment/2
	@DeleteMapping("/delete-comment/{comment-id}")
	public void deleteComment(@PathVariable("comment-id")Long id) {
		commentService.deleteComment(id);
	}

	// http://localhost:8089/wecare/forum/page/2
	/*@GetMapping("/page/{pageNumber}")
	public ResponseEntity<List<Posts>> getPostsPaginated(@PathVariable final Integer pageNumber) {
		return new ResponseEntity<>(this.postService.getAllPaginated(pageNumber), HttpStatus.OK);
	}*/

}
