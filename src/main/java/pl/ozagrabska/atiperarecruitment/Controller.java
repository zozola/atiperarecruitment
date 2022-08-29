package pl.ozagrabska.atiperarecruitment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;

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

    @GetMapping(value = "/show/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ResultData> getRepositories(@PathVariable String user) {
        String url = String.format("https://api.github.com/users/%s/repos", user);
        RestTemplate restTemplate = new RestTemplate();
	GitHubRepo[] repositories;

	try {
        	repositories = restTemplate.getForObject(url, GitHubRepo[].class);
	} catch(HttpClientErrorException exception) {
		throw new GitHubUserNotFoundException();
        }

	ArrayList<ResultData> result = new ArrayList<ResultData>();

	for (GitHubRepo repo : repositories) {
	    if (repo.fork) {
                continue;
            }

            String branch_url = repo.branches_url.substring(0, repo.branches_url.lastIndexOf("{"));
            GitHubBranch[] branches = restTemplate.getForObject(branch_url, GitHubBranch[].class);

            ResultData element = new ResultData();

            element.name = repo.name;
            element.owner = repo.owner.login;

            for (GitHubBranch branch : branches) {
                ResultBranch result_branch = new ResultBranch();

                result_branch.name = branch.name;                
                result_branch.sha = branch.commit.sha;

                element.branches.add(result_branch);
            }

            result.add(element);
	}

        return result;
    }
} 
