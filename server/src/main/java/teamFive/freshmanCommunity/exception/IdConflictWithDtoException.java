package teamFive.freshmanCommunity.exception;

public class IdConflictWithDtoException extends RuntimeException {
    public IdConflictWithDtoException() {
        super("객체와 dto의 id가 일치하지 않습니다.");
    }
}
