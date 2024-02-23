package teamFive.freshmanCommunity.exception;

public class CommentMissingContentException extends RuntimeException{
    public CommentMissingContentException(){
        super("댓글의 내용이 없습니다.");
    }
}
