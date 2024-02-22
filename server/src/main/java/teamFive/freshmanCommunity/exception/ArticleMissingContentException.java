package teamFive.freshmanCommunity.exception;

public class ArticleMissingContentException extends RuntimeException {
    public ArticleMissingContentException() {
        super("게시글의 제목이나 내용이 빠져있습니다.");
    }
}
