package teamFive.freshmanCommunity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import teamFive.freshmanCommunity.entity.Article;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ArticleDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private Long memberId;
    private Long majorId;

    public static ArticleDto createArticleDto(Article n) {
        return new ArticleDto(
                n.getId(),
                n.getTitle(),
                n.getContent(),
                n.getCreateDate(),
                n.getMember().getId(),
                n.getMajor().getId()
        );
    }
}
