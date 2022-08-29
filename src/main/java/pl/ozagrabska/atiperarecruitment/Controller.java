package pl.ozagrabska.atiperarecruitment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;

import java.util.*;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello from Controller!";
    }

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String jsonTest() {
        return "[{\"test\" : \"test\"}]";
    }

    @GetMapping(value = "/show", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> getRepositories() {
        String url = "http://localhost:8080/test";
        RestTemplate restTemplate = new RestTemplate();

        Object[] repositories = restTemplate.getForObject(url, Object[].class);

        return Arrays.asList(repositories);
    }
} 
