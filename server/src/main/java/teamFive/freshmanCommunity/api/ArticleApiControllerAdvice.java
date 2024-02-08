package teamFive.freshmanCommunity.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import teamFive.freshmanCommunity.exception.NonExistentBoardIdException;

@RestControllerAdvice
@Slf4j
public class ArticleApiControllerAdvice {
    @ExceptionHandler(NonExistentBoardIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String nonExistentBoardIdExceptionHandler(NonExistentBoardIdException e) {
        log.error("{}", e.getMessage());
        return e.getMessage();
    }
}
