package teamFive.freshmanCommunity.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BoardNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String nonExistentBoardIdExceptionHandler(BoardNotFoundException e) {
        log.error("{}", e.getMessage());
        return e.getMessage();
    }
}
