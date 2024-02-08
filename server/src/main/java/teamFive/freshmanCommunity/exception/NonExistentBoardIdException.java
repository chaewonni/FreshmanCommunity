package teamFive.freshmanCommunity.exception;

public class NonExistentBoardIdException extends RuntimeException{
    public NonExistentBoardIdException() {
        super("존재하지 않는 게시판입니다.");
    }
}
