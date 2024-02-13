package teamFive.freshmanCommunity.exception;

public class BoardNotFoundByIdException extends RuntimeException{
    public BoardNotFoundByIdException() {
        super("게시물 id가 존재하지 않는 게시판입니다.");
    }
}
