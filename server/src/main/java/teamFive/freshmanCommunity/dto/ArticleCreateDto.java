package teamFive.freshmanCommunity.dto;

import lombok.Getter;
import teamFive.freshmanCommunity.entity.Article;

@Getter
public class ArticleCreateDto {
    private Long id;
    private String title;
    private String content;

    public static ArticleDto createArticleDto(Article n) {
        return new ArticleDto(
                n.getId(),
                n.getTitle(),
                n.getContent(),
                n.getCreateDate(),
                n.getMember(),
                n.getMajor()
        );
    }

}
