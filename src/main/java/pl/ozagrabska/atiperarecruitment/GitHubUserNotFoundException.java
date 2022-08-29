package pl.ozagrabska.atiperarecruitment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.*;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class GitHubUserNotFoundException extends RuntimeException {}
