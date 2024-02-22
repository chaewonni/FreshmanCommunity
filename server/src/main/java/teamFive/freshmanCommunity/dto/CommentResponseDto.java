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
        MemberInfoDto memberInfo = null;

        if(comment.getMember() != null) {
            MemberInfoDto dto = MemberInfoDto.createMemberDto(comment.getMember());
            memberInfo = new MemberInfoDto(
                    dto.getId(),
                    dto.getMemberName(),
                    dto.getStudentId(),
                    dto.getMajor()
            );

        }
        return new CommentResponseDto(
                comment.getId(),
                comment.getContent(),
                comment.getCreateDate(),
                comment.getLikesCount(),
                memberInfo,
                comment.getArticle().getId());
    }
}
