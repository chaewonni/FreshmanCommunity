package teamFive.freshmanCommunity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import teamFive.freshmanCommunity.entity.Article;
import teamFive.freshmanCommunity.entity.Major;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyBookmarkDto {
    private Long id;
    private String title;
    private String content;
    private String createDate;
    private LoginResponseDto member;
    private Major major;

    public static MyBookmarkDto createMyBookmarkDto(Article article){
        return new MyBookmarkDto(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getCreateDate(),
                LoginResponseDto.createLoginDto(article.getMember()),
                article.getMajor()
        );
    }
}