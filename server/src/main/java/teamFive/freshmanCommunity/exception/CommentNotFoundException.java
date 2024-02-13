package teamFive.freshmanCommunity.exception;

public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException(){
        super("존재하지 않는 댓글입니다.");
    }
}
