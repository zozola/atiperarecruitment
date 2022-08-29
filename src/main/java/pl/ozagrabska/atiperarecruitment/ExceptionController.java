package pl.ozagrabska.atiperarecruitment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<AtiperaError> handleNotAcceptableException() {
        AtiperaError response = new AtiperaError();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
	    response.setMessage("supports only json");
	    response.setStatus(406);

	    return new ResponseEntity<AtiperaError>(response, headers, HttpStatus.NOT_ACCEPTABLE);
    }

}