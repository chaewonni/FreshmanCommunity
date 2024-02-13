package teamFive.freshmanCommunity.dto;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import teamFive.freshmanCommunity.entity.Article;
import teamFive.freshmanCommunity.entity.Major;
import teamFive.freshmanCommunity.entity.Member;
import teamFive.freshmanCommunity.exception.IllegalArticleIdException;

import java.time.LocalDateTime;

@Getter
public class CreateArticleDto {
    private Long id;
    private String title;
    private String content;

    public static ArticleDto createArticleDto(Article n) {
        return new ArticleDto(
                n.getId(),
                n.getTitle(),
                n.getContent(),
                n.getCreateDate(),
                n.getMember()
        );
    }

}
