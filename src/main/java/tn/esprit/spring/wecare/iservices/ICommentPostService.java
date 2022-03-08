package tn.esprit.spring.wecare.iservices;

import java.util.List;

import tn.esprit.spring.wecare.entities.CommentPost;
import tn.esprit.spring.wecare.entities.User;

public interface ICommentPostService {

	public CommentPost createAndAffectCommentToPostAndUser(CommentPost cp,Long userId,Long postId);
	public List<CommentPost> getCommentByPostId(Long id);
	public CommentPost updateComment(CommentPost cp,Long id);
	public void deleteComment(Long id);
	public void likeAComment(Long idComment , Long userId);
	public void dislikeAComment(Long idComment, Long userId );
	public void CommentAComment(CommentPost cp,Long commentId, Long idUser );
}
