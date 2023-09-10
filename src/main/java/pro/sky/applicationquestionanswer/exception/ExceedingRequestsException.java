package pro.sky.applicationquestionanswer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ExceedingRequestsException extends RuntimeException{
    public ExceedingRequestsException(String message) {
        super(message);
    }
}
