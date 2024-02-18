package teamFive.freshmanCommunity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
    private LoginResponseDto member;
    private Long articleId;    //article FK

    public static CommentResponseDto createCommentDto(Comment comment){
        return new CommentResponseDto(
                comment.getId(),
                comment.getContent(),
                comment.getCreateDate(),
                comment.getLikesCount(),
                LoginResponseDto.createLoginDto(comment.getMember()),
                comment.getArticle().getId());
    }
}
