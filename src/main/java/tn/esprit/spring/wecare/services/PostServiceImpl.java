package tn.esprit.spring.wecare.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.wecare.dto.UserPosts;
import tn.esprit.spring.wecare.entities.BestAndWorstPost;
import tn.esprit.spring.wecare.entities.Departement;
import tn.esprit.spring.wecare.entities.Posts;
import tn.esprit.spring.wecare.entities.User;
import tn.esprit.spring.wecare.iservices.IPostservice;
import tn.esprit.spring.wecare.repositories.DepartementRepository;
import tn.esprit.spring.wecare.repositories.PostRepository;
import tn.esprit.spring.wecare.repositories.UserRepository;

@Service
@Slf4j
public class PostServiceImpl implements IPostservice {

	@Autowired
	PostRepository postRepo;

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	DepartementRepository departementRepo;
	
	@Override
	public Posts createPost(Posts p) {
		try{
		log.info("in Method CreatePost");
		postRepo.save(p);
		log.info("the post is saved");
		log.info("out of the method CreatePost");}
		catch (Exception e) {
			log.error("out of method CreatePost");
		}
		return postRepo.save(p);
	}



	@Override
	public List<Posts> getAllPosts() {
		log.info("In Method retrieve All Post");

		return postRepo.findAll();
	}

	@Override
	public Posts getPostById(Long id) {
		log.info("In Method retrieve Post By Id");
		return postRepo.findById(id).get();
	}

	@Override
	public void deletePostById(Long id) {
		log.info("In Method delete Post");
		log.info("i'm gonna delete the Post");
		postRepo.deleteById(id);
		log.info("Out Of Method delete Post without errors");

	}



	@Override
	public Posts updatePost(Posts p,Long id) {
		Posts pp = postRepo.findById(id).get();
		pp.setImagePost(p.getImagePost());
		pp.setTitlePost(p.getTitlePost());
		
		return this.postRepo.save(p);
	}
	
	public List<Posts> getAllPostSorted(){
		return postRepo.findAllSortedByDateReverse();
	}



	@Override

	public Posts createPostAndAffectToUser(Posts p,Long userId) {
		
	 
	   User u = userRepo.findById(userId).orElse(null);
	   log.info("userid :"+userId);
	   p.setUser(u);
	   u.getPosts().add(p);
	   postRepo.save(p); 
	   return p;
	 
	 
	
	}
	
	@Override
	public Posts createPostAndAffectToUserAndDepartement(Posts p,Long userId,Long depId) {
		
	   Departement d = departementRepo.findById(depId).orElse(null);
	   log.info("departement :"+d.toString());
	   User u = userRepo.findById(userId).orElse(null);
	   log.info("userid :"+userId);
	   p.setUser(u);
	   List<Departement> l=p.getDepartements();
	   l.add(d);
       p.setDepartements(l);
       
       departementRepo.save(d);
	   postRepo.save(p); 
	   return p;
	 
	 
	
	}
	
	@Override
	public void likeAPost(Long idPost , Long id) {
	Posts p = postRepo.findById(idPost).orElseGet(null);
	User u = userRepo.findById(id).orElseGet(null);
	Set<User> l = p.getUserLikes();
	if(p.getUserDislikes().contains(u))
	{
		p.getUserDislikes().remove(u);
		l.add(u);
		p.setUserLikes(l);
		}
	else
	{	if(p.getUserLikes().contains(u)) {
		p.getUserLikes().remove(u);	
	}
	else {l.add(u);}
	}
	postRepo.save(p);
 
	}
	
	

@Override
	public void dislikeAPost(Long idPost, Long id ) {
 	 
		Posts p = postRepo.findById(idPost).orElseGet(null);
		User u = userRepo.findById(id).orElseGet(null);
		Set<User> l = p.getUserDislikes();
		if(p.getUserLikes().contains(u))
		{
			p.getUserLikes().remove(u);
			l.add(u);
			p.setUserDislikes(l);
			}
		else
		{	l.add(u);}
		postRepo.save(p);
			  
	   }



	@Override
	public BestAndWorstPost bestPost() {
		
		return postRepo.bestPost();
	}
	
	@Override
	public BestAndWorstPost worstPost() {
		
		return postRepo.worstPost();
	}
	
	
	@Override
	public List<UserPosts> searchbyname(String name) {
 		return  postRepo.PostbyName(name);
	}
	
	
	  /*public List<Posts> getAllPaginated(final Integer pageNumber) {
	        Integer index = pageNumber - 1;
	        Page<Posts> posts = this.postRepo.findAll(PageRequest.of(index, 20));
	        return posts.stream().collect(Collectors.toList());
	    }
	  */
	  
	/*  public void uploadImage(final MultipartFile file) throws IOException {
	        UUID imgGeneratedId = UUID.nameUUIDFromBytes(file.getBytes());
	        File convertFile = new File("src/main/frontend/src/assets/images/" + imgGeneratedId + file.getOriginalFilename());
	        Posts foundPost = postRepo.findFirstByOrderByIdDesc();
	        foundPost.setImagePost("./assets/images/" + imgGeneratedId + file.getOriginalFilename());
	        convertFile.createNewFile();
	        FileOutputStream fout = new FileOutputStream(convertFile);
	        fout.write(file.getBytes());
	        fout.close();
	        postRepo.save(foundPost);
	    }*/ 

}
