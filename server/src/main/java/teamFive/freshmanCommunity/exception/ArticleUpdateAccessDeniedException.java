package teamFive.freshmanCommunity.exception;

public class ArticleUpdateAccessDeniedException extends RuntimeException {
    public ArticleUpdateAccessDeniedException() {
        super("게시글 수정 권한이 없습니다.");
    }
}
