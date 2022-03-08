package tn.esprit.spring.wecare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.wecare.entities.PublicationComments;

@RestController
@RequestMapping("/actuality")
public class PublicationCommentController {
	
	@Autowired
tn.esprit.spring.wecare.iservices.PublicationCommentIservice PublicationCommentIservice;

	@PostMapping("/add-comment/{pub-id}/{id-User}") 
	public PublicationComments addCommPublicationComments(@RequestBody PublicationComments PubCom  ,@PathVariable("pub-id") Long id ,@PathVariable("id-User") Long idUser) {
		
		return PublicationCommentIservice.addCommPublicationComments(PubCom, id, idUser);
	}
	
	
	@PutMapping("/update-comment/{Comm-id}") 
	public PublicationComments UpdateComment(@RequestBody PublicationComments PubCom, @PathVariable("Comm-id")Long idComm ) {
		
		return PublicationCommentIservice.UpdateComment(PubCom, idComm);
	}
	
	@PutMapping("/likeComment/{idComm}/{idUser}")
	public void likeAComment(@PathVariable("idComm")Long idComm , @PathVariable("idUser")Long idUser )
	{	
		PublicationCommentIservice.likeAComment(idComm, idUser);
		
	}
	
	@PutMapping("/DislikeComment/{idComm}/{idUser}")
	public void DislikeAComment(@PathVariable("idComm")Long idComm , @PathVariable("idUser")Long idUser )
	{	
		PublicationCommentIservice.DislikeAComment(idComm, idUser);
		
	}
	
	
	@DeleteMapping("/remove-comment/{comment-id}")
	public void deleteComment(@PathVariable("comment-id") Long idComm) {
		PublicationCommentIservice.deleteComment(idComm);
	}
	
	@GetMapping("/get-allpubsCommdate/{post-id}")
	public List<PublicationComments> getAllPublCommentsbydate(@PathVariable("post-id") Long id){
		List<PublicationComments> listPubs = PublicationCommentIservice.getAllPublCommentsbydate(id);
		return listPubs;
	}
	
}
