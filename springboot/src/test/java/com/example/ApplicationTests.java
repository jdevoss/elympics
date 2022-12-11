package com.example;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private VisitorController controller;

	@Autowired
	private PostRepository postRepository;

	@Test
	@Order(1)
	void contextLoads() throws Exception {
			assertThat(controller).isNotNull();
	}

	@Test
	@Order(2)
	public void shouldAddPost() throws Exception {
		// Generate a random number for testing
		double randomNumber = Math.random() * 100;
		// Add new post with random number to repository
		Post post = new Post();
		post.setTitle("Lorem ipsum test " + randomNumber);
		post.setDescription("This is a test text. Lorem ipsum sit amet " + randomNumber);
		postRepository.save(post);
		// Check if the new post was successfully added
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/posts/all", String.class)).contains("Lorem ipsum test " + randomNumber);
		// cleanup
		controller.deleteVisitor(post.getId());
	}

	@Test
	@Order(3)
	public void shouldReturnAllPosts() throws Exception {
		// Get all posts from controller
		List<Post> actualList = new ArrayList<Post>();
		controller.getAllVisitors().iterator().forEachRemaining(actualList::add);

		// Get all posts from api
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = this.restTemplate.getForObject("http://localhost:" + port + "/posts/all", JsonToken.START_ARRAY.asString().getClass());
		List<Post> postJsonList = mapper.readValue(jsonString, new TypeReference<List<Post>>(){});

		// Check if lists are the same size
		assertThat(postJsonList.size()).isEqualTo(actualList.size());
	}

	@Test
	@Order(4)
	public void postHasCorrectText() throws Exception {
		// Generate a random number for testing
		double randomNumber = Math.random() * 100;

		Post post = new Post();
		post.setTitle("Lorem ipsum test " + randomNumber);
		post.setDescription("This is a test text. Lorem ipsum sit amet " + randomNumber);

		// Add new post with random number to repository
		postRepository.save(post);
		// Check if the new post was successfully added
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/posts/all", String.class)).contains("This is a test text. Lorem ipsum sit amet " + randomNumber);

		// cleanup test post
		controller.deleteVisitor(post.getId());
	}

}
