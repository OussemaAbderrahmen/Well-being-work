package tn.esprit.spring.wecare.iservices;

import java.util.List;

import tn.esprit.spring.wecare.entities.CommentPost;

public interface ICommentPostService {

	public CommentPost createAndAffectCommentToPost(CommentPost cp,Long id);
	public List<CommentPost> getCommentByPostId(Long id);
	public CommentPost updateComment(CommentPost cp);
	public void deleteComment(Long id);
}
