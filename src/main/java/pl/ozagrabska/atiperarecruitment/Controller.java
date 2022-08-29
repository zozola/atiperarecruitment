package pl.ozagrabska.atiperarecruitment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello from Controller!";
    }

    @GetMapping("/show")
    public List<Object> getCountries() {
        String url = "https://cat-fact.herokuapp.com/facts";
        RestTemplate restTemplate = new RestTemplate();

        Object[] countries = restTemplate.getForObject(url, Object[].class);

        return Arrays.asList(countries);
    }
} 
