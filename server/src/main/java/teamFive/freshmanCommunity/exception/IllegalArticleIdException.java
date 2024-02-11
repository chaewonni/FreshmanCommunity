package teamFive.freshmanCommunity.exception;

public class IllegalArticleIdException extends RuntimeException {
    public IllegalArticleIdException() {
        super("게시글 생성 전 id가 존재할 수 없습니다.");
    }
}
