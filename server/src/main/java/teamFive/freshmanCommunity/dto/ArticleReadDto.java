package teamFive.freshmanCommunity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ArticleReadDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LoginResponseDto memberReadDto;

}
