package teamFive.freshmanCommunity.exception;

public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException() {
        super ("게시글 조회에 실패하였습니다.");
    }
}
