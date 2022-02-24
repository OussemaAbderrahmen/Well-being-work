package tn.esprit.spring.wecare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return postRepo.save(p);
	}



	@Override
	public List<Posts> getAllPosts() {
		
		return postRepo.findAll();
	}

	@Override
	public Posts getPostById(Long id) {
		
		return postRepo.findById(id).orElse(null);
	}

	@Override
	public void deletePostById(Long id) {
		postRepo.deleteById(id);
	}



	@Override
	public Posts updatePost(Posts p) {
		
		return this.postRepo.save(p);
	}

}
