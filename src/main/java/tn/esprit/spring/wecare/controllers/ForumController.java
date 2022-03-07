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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.wecare.dto.UserPosts;
import tn.esprit.spring.wecare.entities.BestAndWorstPost;
import tn.esprit.spring.wecare.entities.CommentPost;
import tn.esprit.spring.wecare.entities.Departement;
import tn.esprit.spring.wecare.entities.Dictionary;
import tn.esprit.spring.wecare.entities.MostDynamicUser;
import tn.esprit.spring.wecare.entities.Posts;
import tn.esprit.spring.wecare.services.CommentPostServiceImpl;
import tn.esprit.spring.wecare.services.DepartementServiceImpl;
import tn.esprit.spring.wecare.services.DictionnaryServiceImpl;
import tn.esprit.spring.wecare.services.PostServiceImpl;
import tn.esprit.spring.wecare.services.UserServiceImpl;
@Slf4j
@RestController
@RequestMapping("/forum")
public class ForumController {
	@Autowired
	PostServiceImpl postService;
	@Autowired
	CommentPostServiceImpl commentService;
	@Autowired
	DepartementServiceImpl departementService;
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	DictionnaryServiceImpl dictionaryService;

	//----------------------------------------------------------POST------------------------------------------------------------------------------------------------

	// http://localhost:8089/wecare/forum/create-post
	@PostMapping("/create-post")
	public void createPost(@RequestBody Posts post) {

		 postService.createPost(post);
	}
	
	// http://localhost:8089/wecare/forum/create-full-post/1

	@PostMapping("/create-full-post/{user-id}")
	public Posts createPostAndAffectToUser(@RequestBody Posts p,@PathVariable("user-id")Long userId){
		
		
		return postService.createPostAndAffectToUser(p, userId);
	}
	
	// http://localhost:8089/wecare/forum/create-full-post/1/1
	@PostMapping("/create-full-post/{user-id}/{dep-id}")
	public Posts createPostAndAffectToDeparmentAndUser(@RequestBody Posts p,@PathVariable(name="user-id")Long userId,@PathVariable(name="dep-id")Long depId){
		   //log.info("departement :"+userId.toString());

		   //log.info("departement :"+userId.toString());

		return postService.createPostAndAffectToUserAndDepartement(p, userId, depId);
		
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
	// http://localhost:8089/wecare/forum/get-all-postsSorted
	@GetMapping("/get-all-postsSorted")
	public List<Posts> getAllSorted() {
		List<Posts> listPosts = postService.getAllPostSorted();
		return listPosts;
	}
	
	// http://localhost:8089/wecare/forum/get-best-post-by-month
		@GetMapping("/get-best-post-by-month")
		public List<BestAndWorstPost> getbestPostByMonth() {
			List<BestAndWorstPost> listPosts = postService.bestPostByMonth();
			return listPosts;
		}
	
	
	
	
	
	// http://localhost:8089/wecare/forum/searchbyname/thisisatest
	@GetMapping("/searchbyname/{name}")
	public List<UserPosts> searchByName ( @PathVariable("name") String name)
	{
		return postService.searchbyname(name);
	}
	
	//-------------------------------------Search By title and description Angular -----------------------------------------------
	// http://localhost:8089/wecare/forum/searchByTitle/thisisatest
		@GetMapping("/searchByTitle/{title}")
		public List<UserPosts> searchByTitle ( @PathVariable("title") String title)
		{
			return postService.searchByTitle(title);
		}
		// http://localhost:8089/wecare/forum/searchbyDescription/thisisatest
		@GetMapping("/searchbyDescription/{description}")
		public List<UserPosts> searchByDescription ( @PathVariable("description") String description)
		{
			return postService.searchbyDescription(description);
		}
		
	//-------------------------------------End By title and description Angular -----------------------------------------------


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
	
	//http://localhost:8089/wecare/forum/likepost/{idPost}/{id}
	@PutMapping("/likepost/{idPost}/{id}")
	public void LikePost( @PathVariable("idPost") Long idPost , @PathVariable("id") Long id)
	{	
		 postService.likeAPost(idPost, id) ;
		
	}
	
	

	//http://localhost:8089/wecare/forum//disLikepost/{idPost}/{id}

	@PutMapping("/disLikepost/{idPost}/{id}")
	public void DisLikePost( @PathVariable("idPost") Long idPost , @PathVariable("id") Long id)
	{	 
		postService.dislikeAPost(idPost, id) ;
	
    }
	
	
	//http://localhost:8089/wecare/forum/getbestpost

	@GetMapping("/getbestpost")
	public BestAndWorstPost getBestPost(){
		return postService.bestPost();
	}
	
	
	//http://localhost:8089/wecare/forum/getworstpost

		@GetMapping("/getworstpost")
		public BestAndWorstPost getWorstPost(){
			return postService.worstPost();
		}
	
	//---------------------------------------------------------COMMENT --------------------------------------------------------------

	// http://localhost:8089/wecare/forum/add-comment/1/2
	@PostMapping("/add-comment/{post-id}/{user-id}")
	public CommentPost addComment(@RequestBody CommentPost cp, @PathVariable(name="post-id") Long idPost,@PathVariable(name="user-id") Long userId) {

		return commentService.createAndAffectCommentToPostAndUser(cp, userId, idPost);

	}
	//http://localhost:8089/wecare/forum/retrieve-all-comments
	@GetMapping("/retrieve-all-comments")
	public List<CommentPost> retrieveAllComments(){
		return commentService.getAllComment();
	}
	
	
	//http://localhost:8089/wecare/forum/retrieve-comment-by-id/23
	@GetMapping("/retrieve-comment-by-id/{id}")
	public CommentPost retrieveCommentByIyd(@PathVariable("id") Long id){
		return commentService.getCommentById(id);
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
	
	//http://localhost:8089/wecare/forum/likecomment/{comment-id}/{user-id}

	@PutMapping("/likecomment/{comment-id}/{user-id}")
	public void likeComment( @PathVariable(name="comment-id") Long commentId , @PathVariable(name="user-id") Long userId)
	{	 
		commentService.likeAComment(commentId, userId);
	
    }
	
	//http://localhost:8089/wecare/forum/dislikecomment/{comment-id}/{user-id}
	@PutMapping("/dislikecomment/{comment-id}/{user-id}")
	public void dislikeComment( @PathVariable("comment-id") Long commentId , @PathVariable("user-id") Long userId)
	{	 
		commentService.dislikeAComment(commentId, userId);
	
    }
	
	//http://localhost:8089/wecare/forum/addcommenttocomment/{comment-id}/{user-id}
	@PostMapping("/addcommenttocomment/{comment-id}/{user-id}")
	public void commentaComment(@PathVariable(name="comment-id") Long commentid , @RequestBody CommentPost response , @PathVariable(name ="user-id") Long idUser)
	{
				 commentService.CommentAComment(response, commentid, idUser);
	}

	// http://localhost:8089/wecare/forum/page/2
	/*@GetMapping("/page/{pageNumber}")
	public ResponseEntity<List<Posts>> getPostsPaginated(@PathVariable final Integer pageNumber) {
		return new ResponseEntity<>(this.postService.getAllPaginated(pageNumber), HttpStatus.OK);
	}*/

	//----------------------------------------------------------------------DEPARTEMENT-------------------------------------------------------------------
	
	//http://localhost:8089/wecare/forum/create-departement
	@PostMapping("/create-departement")
	public void addDepartement(@RequestBody Departement d){
		departementService.createDepartement(d);
	}
	//http://localhost:8089/wecare/forum/get-all-departement
	@GetMapping("/get-all-departement")
	public List<Departement> getAllDepartements(){
		return departementService.getAllDepartement();
	}
	//http://localhost:8089/wecare/forum/update-departement/2
	@PutMapping("update-departement/{departement-id}")
	public Departement updateDepratement(@RequestBody Departement d, @PathVariable("departement-id") Long departementId){
		return departementService.updateDepartement(d, departementId);
	}
	//http://localhost:8089/wecare/forum/delete-departement/2
	@DeleteMapping("delete-departement/{departement-id}")
		public void deleteDepartement(@PathVariable("departement-id") Long departementId){
			departementService.deleteDepartement(departementId);
		}
	
	//http://localhost:8089/wecare/forum/addword
		@PostMapping("/addword")
		public Dictionary addword(@RequestBody Dictionary dd)
		{
			return dictionaryService.addWord(dd);
		}
		
		//http://localhost:8089/wecare/forum/getAllWord
				@GetMapping("/getAllWord")
				public List<Dictionary> getAllWord()
				{
					 return dictionaryService.getBadWords();
				}
				
	 //http://localhost:8089/wecare/forum/getMostActiveUser
			@GetMapping("/getMostActiveUser")
				public MostDynamicUser getMostActiveUser(){
					return postService.getMostActiveUser();
				}
	}
