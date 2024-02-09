package teamFive.freshmanCommunity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import teamFive.freshmanCommunity.entity.Article;
import teamFive.freshmanCommunity.entity.Comment;
import teamFive.freshmanCommunity.entity.LikeComment;
import teamFive.freshmanCommunity.entity.Member;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommentDto {
    private Long id;
    private String content;
    private LocalDateTime createDate;
    private int likesCount;
    private Member member;  //member FK
    private Article article;    //article FK

    public static CommentDto createCommentDto(Comment comment){
        return new CommentDto(comment.getId(), comment.getContent(), comment.getCreateDate(), comment.getLikesCount(), comment.getMember(), comment.getArticle());
    }
}
