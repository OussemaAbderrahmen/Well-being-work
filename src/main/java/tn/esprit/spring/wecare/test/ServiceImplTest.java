package tn.esprit.spring.wecare.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



import tn.esprit.spring.wecare.entities.Posts;
import tn.esprit.spring.wecare.repositories.PostRepository;
import tn.esprit.spring.wecare.services.PostServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceImplTest {

	@Autowired
	PostServiceImpl postServiceImpl;
	@Autowired
	PostRepository postRepo;

	@Test
	public void testAddClient() {
		Posts cp = new Posts("test",1,2,"this test");
		
			Posts savedPost= postServiceImpl.createPost(cp);
			assertEquals(cp.getTitlePost(),savedPost.getTitlePost());
			
	
	}
	
}
