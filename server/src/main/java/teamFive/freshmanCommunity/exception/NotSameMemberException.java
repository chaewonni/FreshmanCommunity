package teamFive.freshmanCommunity.exception;

public class NotSameMemberException extends RuntimeException{
    public NotSameMemberException(){
        super("본인이 작성한 글이 아니기 때문에 수정 및 삭제가 불가능합니다.");
    }
}
