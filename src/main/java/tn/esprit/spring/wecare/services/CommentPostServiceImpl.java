package tn.esprit.spring.wecare.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.wecare.entities.CommentPost;
import tn.esprit.spring.wecare.entities.Dictionary;
import tn.esprit.spring.wecare.entities.Entreprise;
import tn.esprit.spring.wecare.entities.Posts;
import tn.esprit.spring.wecare.entities.Publication;
import tn.esprit.spring.wecare.entities.User;
import tn.esprit.spring.wecare.iservices.ICommentPostService;
import tn.esprit.spring.wecare.repositories.CommentPostRepository;
import tn.esprit.spring.wecare.repositories.DictionaryRepository;
import tn.esprit.spring.wecare.repositories.PostRepository;
import tn.esprit.spring.wecare.repositories.UserRepository;

@Service
@Slf4j
public class CommentPostServiceImpl implements ICommentPostService {

	@Autowired
	CommentPostRepository commentRepo;
	@Autowired
	PostRepository postRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	DictionaryRepository dicRepo;



	public List<CommentPost> getAllComment(){
		return commentRepo.findAll();
	}
	
	@Override
	public List<CommentPost> getCommentByPostId(Long id) {
		Posts p = postRepo.findById(id).orElse(null);
		List<CommentPost> comments = p.getCommentposts();
		return comments;
	}

	@Override
	public void deleteComment(Long id) {
		
		log.info("In Method Delete comment");
		log.info("Im gonna delete the comment");
		commentRepo.deleteById(id);
		log.info("Out Of Method delete Comment succefully");
	}

	@Override
	public CommentPost updateComment(CommentPost cp,Long id) {
        CommentPost p=commentRepo.getById(id);
        p.setComment(cp.getComment());
        p.setCommentDate(cp.getCommentDate());
        p.setPosts(cp.getPosts());
        
		return commentRepo.save(p);
	}

	public CommentPost getCommentById(Long id) {
		return commentRepo.findById(id).orElse(null);
	}
	


	@Override
	public CommentPost createAndAffectCommentToPostAndUser(CommentPost cp, Long userId, Long postId) {
		

		User user = userRepo.findById(userId).get();
		Posts p = postRepo.findById(postId).get();
		String text = cp.getComment();
		List<Dictionary> badwords =  dicRepo.findAll();
		int compteur = 0;
		for(int i =0 ; i < badwords.size(); i++)
		{
			if(text.contains(badwords.get(i).getWord()))
			{
				
				compteur ++;
			}
		}
		
		if(compteur>0) {
			
			System.out.println("This message was blocked because a bad word was found."
					+ "If you believe this word should not be blocked, please message support.");
			return null;
		}
		else 
		{
		int nbcomm=p.getNbComment()+1;
		p.setNbComment(nbcomm);
		postRepo.save(p);
		Date d = new Date();
		cp.setUser(user);
		cp.setPosts(p);
		cp.setCommentDate(d);
		
		
		return commentRepo.save(cp);}
	}

		


	

	@Override
	public void likeAComment(Long idComment, Long userId) {
		CommentPost cp = commentRepo.findById(idComment).orElseGet(null);
		User u = userRepo.findById(userId).orElseGet(null);
		Set<User> l = cp.getUserCommentLikes();
		if(cp.getUserCommentDislikes().contains(u))
		{
			cp.getUserCommentDislikes().remove(u);
			l.add(u);
			cp.setUserCommentLikes(l);
			}
		else
		{	if(cp.getUserCommentDislikes().contains(u)) {
			cp.getUserCommentLikes().remove(u);	
		}
		else {l.add(u);}
		}
		commentRepo.save(cp);
	 
		
	}

	@Override
	public void dislikeAComment(Long idComment, Long userId) {
		CommentPost cp = commentRepo.findById(idComment).orElseGet(null);
		User u = userRepo.findById(userId).orElseGet(null);
		Set<User> l = cp.getUserCommentDislikes();
		if(cp.getUserCommentLikes().contains(u))
		{
			cp.getUserCommentLikes().remove(u);
			l.add(u);
			cp.setUserCommentDislikes(l);
			}
		else
		{	l.add(u);}
		commentRepo.save(cp);
		
	}

	@Override
	public void CommentAComment(CommentPost comment, Long commentid, Long idUser) {
		
				User u = userRepo.findById(idUser).orElseGet(null);
				comment.setUser(u);
				CommentPost c = new CommentPost();
				c.setCommId(commentid);
				comment.setResponse(c);
				//comment.setPosts(c.getPosts());
				
				commentRepo.save(comment);
				
		
	}

	
	/*public int Like(Long id){
	
	CommentPost p= commentRepo.findById(id).orElse(null);
	int likes=p.getLikeikes();
	return likes+1;

}

public int dislike(Long id){
	CommentPost p= commentRepo.findById(id).orElse(null);
	int dislikes=p.getDislikes();
	return dislikes+1;
	
}*/
}
