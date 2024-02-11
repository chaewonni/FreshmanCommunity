package teamFive.freshmanCommunity.exception;

public class BoardNotFoundException extends RuntimeException{
    public BoardNotFoundException() {
        super("존재하지 않는 게시판입니다.");
    }
}
