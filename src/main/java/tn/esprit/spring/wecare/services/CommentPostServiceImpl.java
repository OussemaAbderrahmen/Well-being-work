package tn.esprit.spring.wecare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.wecare.entities.CommentPost;
import tn.esprit.spring.wecare.entities.Posts;
import tn.esprit.spring.wecare.iservices.ICommentPostService;
import tn.esprit.spring.wecare.repositories.CommentPostRepository;
import tn.esprit.spring.wecare.repositories.PostRepository;
@Service
@Slf4j
public class CommentPostServiceImpl implements ICommentPostService {

	@Autowired
	CommentPostRepository commentRepo;
	@Autowired
	PostRepository postRepo;
	@Override
	public CommentPost createAndAffectCommentToPost(CommentPost cp,Long id) {

		Posts p=postRepo.findById(id).orElse(null);
	
		p.getCommentposts().add(cp);
		return this.commentRepo.save(cp);
	}

	@Override
	public List<CommentPost> getCommentByPostId(Long id) {
		Posts p=postRepo.findById(id).orElse(null);
		List<CommentPost> comments =p.getCommentposts();
		return comments;
	}


	@Override
	public void deleteComment(Long id) {
		  commentRepo.deleteById(id);
	}

	@Override
	public CommentPost updateComment(CommentPost cp) {
		
		return commentRepo.save(cp);
	}
	
	public CommentPost getCommentById(Long id){
		return commentRepo.findById(id).orElse(null);
	}

}
