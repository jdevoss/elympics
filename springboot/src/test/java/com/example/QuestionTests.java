package com.example;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class QuestionTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Autowired
    private QuestionRepository questionRepository;

    private QuestionController questionController;

    Question question = new Question("Hydro", "Space", 100);

    //repository tests
    @Test
    @Order(1)
    void findAllQuestions(){
        List<Question> questionList = (List<Question>) questionRepository.findAll();
        assertEquals(35, questionList.size());
    }

    @Test
    @Order(2)
    void updatingQuestion() {
        question.setTitle("Julian");
        question.setDescription("De Vos");
        questionRepository.save(question);
        assertEquals("Julian", question.getTitle());
    }

    @Test
    @Order(3)
    void addingAQuestion() {
        Question q = new Question("Hydro","Space",120);
        q = questionRepository.save(q);
        assertNotNull(q.getId());
        assertEquals("Hydro", q.getTitle());
        assertEquals("Space", q.getDescription());
    }

    // controller tests
    @Test
    @Order(4)
    void createQuestion() {
        // Post request a new user
        ResponseEntity<Question> creationResult =
                this.restTemplate.exchange("/questions/add", HttpMethod.POST, new HttpEntity<>(question), Question.class);

        // Request goes through (OK status)
        assertEquals(creationResult.getStatusCode(), HttpStatus.CREATED);

        // User gets a new id
        assertNotNull(creationResult.getBody().getId());

        // Titles are the same
        assertEquals(creationResult.getBody().getTitle(), "Hydro");

        // Descriptions are the same
        assertEquals(creationResult.getBody().getDescription(), "Space");

        // Get request
        ResponseEntity<Question> queryResult =
                this.restTemplate.getForEntity("/questions/" + creationResult.getBody().getId(), Question.class);

        // Http status should still be ok (200)
        assertEquals(queryResult.getStatusCode(), HttpStatus.OK);

    }

    @Test
    @Order(5)
    void CheckForMethodNotAllowedBecauseOfFaultyURL() {

        ResponseEntity<Question> deletionResult =
                this.restTemplate.exchange(
                        "/questions/del" + question.getId(),
                        HttpMethod.DELETE,
                        new HttpEntity<>(question),
                        Question.class
                );


        assertEquals(deletionResult.getStatusCode(), HttpStatus.METHOD_NOT_ALLOWED);

    }
}

