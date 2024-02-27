package teamFive.freshmanCommunity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import teamFive.freshmanCommunity.entity.Article;
import teamFive.freshmanCommunity.entity.Comment;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommentResponseDto {   //댓글 요청시 돌려줄 값
    private Long id;
    private String content;
    private String createDate;
    private int likesCount;
    private MemberInfoDto memberInfo;
    private Long articleId;    //article FK

    public static CommentResponseDto createCommentDto(Comment comment) {
        // 게시글에 연결된 회원 정보가 있으면 MemberInfoDto 객체를 생성, 없으면 memberInfo를 null로 설정
        MemberInfoDto memberInfo = comment.getMember() != null ?
                MemberInfoDto.createMemberDto(comment.getMember()) : null;

        return new CommentResponseDto(
                comment.getId(),
                comment.getContent(),
                comment.getCreateDate(),
                comment.getLikesCount(),
                memberInfo,
                comment.getArticle().getId());
    }
}
