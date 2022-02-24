package tn.esprit.spring.wecare.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.wecare.entities.Posts;
import tn.esprit.spring.wecare.iservices.IPostservice;
import tn.esprit.spring.wecare.repositories.PostRepository;
@Service
@Slf4j
public class PostServiceImpl implements IPostservice {

	@Autowired
	PostRepository postRepo;
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
	public Posts updatePost(Posts p) {
		
		return this.postRepo.save(p);
	}
	
	  public List<Posts> getAllPaginated(final Integer pageNumber) {
	        Integer index = pageNumber - 1;
	        Page<Posts> posts = this.postRepo.findAll(PageRequest.of(index, 20));
	        return posts.stream().collect(Collectors.toList());
	    }
	  
	  
	  public void uploadImage(final MultipartFile file) throws IOException {
	        UUID imgGeneratedId = UUID.nameUUIDFromBytes(file.getBytes());
	        File convertFile = new File("src/main/frontend/src/assets/images/" + imgGeneratedId + file.getOriginalFilename());
	        Posts foundPost = postRepo.findFirstByOrderByIdDesc();
	        foundPost.setImagePost("./assets/images/" + imgGeneratedId + file.getOriginalFilename());
	        convertFile.createNewFile();
	        FileOutputStream fout = new FileOutputStream(convertFile);
	        fout.write(file.getBytes());
	        fout.close();
	        postRepo.save(foundPost);
	    }

}
