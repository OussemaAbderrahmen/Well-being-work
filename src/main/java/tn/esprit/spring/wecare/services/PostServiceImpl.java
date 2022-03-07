package tn.esprit.spring.wecare.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import tn.esprit.spring.wecare.entities.Dictionary;
import tn.esprit.spring.wecare.entities.MostDynamicUser;
import tn.esprit.spring.wecare.entities.Posts;
import tn.esprit.spring.wecare.entities.User;
import tn.esprit.spring.wecare.iservices.IPostservice;
import tn.esprit.spring.wecare.repositories.DepartementRepository;
import tn.esprit.spring.wecare.repositories.DictionaryRepository;
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
	
	@Autowired
	EmailSenderService eService;
	
	@Autowired
	DictionaryRepository dictionaryRepo;
	
	@Override
	public void createPost(Posts p) {
		
		List<User> users = new ArrayList<>();
		users=userRepo.findAll();
		for(User u : users){
			eService.sendSimpleEmail(u.getEmail(), "Hattena Nmout Allik ya rohy malla develepporet aka ahna ", "hattena ya rohy");
		}
		
		try{
		log.info("in Method CreatePost");
		postRepo.save(p);
		log.info("the post is saved");
		log.info("out of the method CreatePost");}
		catch (Exception e) {
			log.error("out of method CreatePost");
		}
		
		 postRepo.save(p);
		
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
		List<User> users = new ArrayList<>();
		users=userRepo.findAll();
		for(User u : users){
			eService.sendSimpleEmail(u.getEmail(), "A new post Has Been added by the admin of the department","WeCare : New Post");
		}
	 
	   User us = userRepo.findById(userId).orElse(null);
	 //  log.info("userid :"+userId);
	   p.setUser(us);
	   us.getPosts().add(p);
	   postRepo.save(p); 
	   return p;
	 
	 
	
	}
	
	@Override
	public Posts createPostAndAffectToUserAndDepartement(Posts p,Long userId,Long depId) {
		
		User uuu = userRepo.findById(userId).get();
		int warning=uuu.getWarningNum();
		
		String textDescription = p.getDescriptionPost();
		String textTitle=p.getTitlePost();
		List<Dictionary> badwords = dictionaryRepo.findAll();
		int compteur=0;
		for(int i =0;i<badwords.size();i++){
			if(textDescription.contains(badwords.get(i).getWord())||textTitle.contains(badwords.get(i).getWord())){
				compteur++;
				warning++;
				
			}
			uuu.setWarningNum(warning);
			userRepo.save(uuu);
		}
		if(compteur>0){
			log.info("this message is blocked because he contain a bad word would you please delete it than try again !! and if you "
					+ "post 2 times with bad words your account will be blocked");
			return null;
		}
		else{
			int comm=0;
			p.setDepartements(new ArrayList<Departement>());
			Departement d = departementRepo.findById(depId).get();
			p.getDepartements().add(d);
			Date dd = new Date();
			   User u = userRepo.findById(userId).get();
			   p.setUser(u);
			   p.setDatePost(dd);
			   p.setNbComment(comm);
			   postRepo.save(p);
			   List<User> users = new ArrayList<>();
				users=userRepo.findAll();
				for(User uu : users){
					eService.sendSimpleEmail(uu.getEmail(), "A new post Has Been added by the admin of the department","WeCare : New Post");
				}
		   return p;
		}
		}

	 
	
	//}
	
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
	
	
	
	
	public MostDynamicUser getMostActiveUser(){
		return postRepo.mostDynamicUser();
	}
	
	
	@Override
	public List<UserPosts> searchbyname(String name) {
 		return  postRepo.postbyFirstName(name);
	}



	@Override
	public List<UserPosts> searchByTitle(String title) {
		return postRepo.postByTitle(title);
	}



	@Override
	public List<UserPosts> searchbyDescription(String description) {
		return postRepo.postByDescription(description);
	}
	

	public List<BestAndWorstPost> bestPostByMonth(){
		return postRepo.bestPostsByMonth();
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
