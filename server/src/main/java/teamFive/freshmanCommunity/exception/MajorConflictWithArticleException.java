package teamFive.freshmanCommunity.exception;

public class MajorConflictWithArticleException extends RuntimeException{
    public MajorConflictWithArticleException() {
        super("접근하는 전공 id와 게시글의 전공 id가 일치하지 않습니다.");
    }
}
