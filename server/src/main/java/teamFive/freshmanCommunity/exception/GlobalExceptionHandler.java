package teamFive.freshmanCommunity.exception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicateMemberException.class)
    public ResponseEntity<String> handleDuplicateMemberException(DuplicateMemberException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<String> handleMemberNotFoundException(MemberNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<String> handleIncorrectPasswordException(IncorrectPasswordException e) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(e.getMessage());
    }

    @ExceptionHandler(BoardNotFoundException.class)
    public ResponseEntity<String> BoardNotFoundExceptionHandler(BoardNotFoundException e) {
        log.error("{}", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler(IllegalArticleIdException.class)
    public ResponseEntity<String> BoardNotFoundExceptionHandler(IllegalArticleIdException e) {
        log.error("{}", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }
  
    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<String> handleCommentNotFoundException(CommentNotFoundException e){
        log.error("{}",e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler(BoardNotFoundByIdException.class)
    public ResponseEntity<String> handleBoardNotFoundByIdException(BoardNotFoundByIdException e){
        log.error("{}", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }
    @ExceptionHandler(MajorConflictWithArticleException.class)
    public ResponseEntity<String> handleMajorConflictWithArticleException(MajorConflictWithArticleException e){
        log.error("{}", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }
    @ExceptionHandler(ArticleNotFoundException.class)
    public ResponseEntity<String> handleArticleNotFoundException(ArticleNotFoundException e){
        log.error("{}", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }
    @ExceptionHandler(IdConflictWithDtoException.class)
    public ResponseEntity<String> handleIdConflictWithDtoException(IdConflictWithDtoException e){
        log.error("{}", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }
    @ExceptionHandler(ArticleUpdateAccessDeniedException.class)
    public ResponseEntity<String> handleArticleUpdateAccessDeniedException(ArticleUpdateAccessDeniedException e){
        log.error("{}", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }

    @ExceptionHandler(NotSameMemberException.class)
    public ResponseEntity<String> handleNotSameMemberException(NotSameMemberException e){
        log.error("{}", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }
}
