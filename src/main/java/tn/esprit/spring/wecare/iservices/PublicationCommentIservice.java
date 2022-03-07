package tn.esprit.spring.wecare.iservices;

import java.util.List;

import tn.esprit.spring.wecare.entities.PublicationComments;

public interface PublicationCommentIservice {

	 public PublicationComments addCommPublicationComments( PublicationComments PubCom, Long id , Long idUser);
	 
		public List<PublicationComments> getAllPublCommentsbydate( Long id);
		 
		 public PublicationComments UpdateComment (PublicationComments PubCom , Long idComm);
		 
		public void deleteComment(Long idComm);
		 
		 public void likeAComment(Long idComm , Long idUser);
		 
		 public void DislikeAComment(Long idComm , Long idUser);
		 
		 
	
}
