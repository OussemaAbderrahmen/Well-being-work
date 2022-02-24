package tn.esprit.spring.wecare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.wecare.entities.CommentPost;
import tn.esprit.spring.wecare.entities.Entreprise;
import tn.esprit.spring.wecare.entities.Posts;
import tn.esprit.spring.wecare.iservices.ICommentPostService;
import tn.esprit.spring.wecare.repositories.CommentPostRepository;
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

	@Override
	public CommentPost createAndAffectCommentToPost(CommentPost cp, Long idPost) {
		
			log.info("in method create And Effect Comment to Post");
			Posts p = postRepo.findById(idPost).orElse(null);
     		p.getCommentposts().add(cp);
     		cp.setPosts(p);
			log.info("post :"+idPost);
			log.info("cp :"+cp.toString());
			

		return commentRepo.save(cp);
		
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
	
	public int Like(Long id){
		
		CommentPost p= commentRepo.findById(id).orElse(null);
		int likes=p.getLikeikes();
		return likes+1;
	
	}
	
	public int dislike(Long id){
		CommentPost p= commentRepo.findById(id).orElse(null);
		int dislikes=p.getDislikes();
		return dislikes+1;
		
	}

}
