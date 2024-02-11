package teamFive.freshmanCommunity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import teamFive.freshmanCommunity.entity.Article;
import teamFive.freshmanCommunity.entity.Major;
import teamFive.freshmanCommunity.entity.Member;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ArticleDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private Member member;
    private Major major;


    public static ArticleDto createArticleDto(Article created) {
        return new ArticleDto(
                created.getId(),
                created.getTitle(),
                created.getContent(),
                created.getCreateDate(),
                created.getMember(),
                created.getMajor()
        );
    }
}
