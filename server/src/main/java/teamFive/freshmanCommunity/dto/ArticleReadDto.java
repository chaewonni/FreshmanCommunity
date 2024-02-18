package teamFive.freshmanCommunity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import teamFive.freshmanCommunity.entity.Major;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ArticleReadDto {
    private Long id;
    private String title;
    private String content;
    private int bookmarkCount;
    private LocalDateTime createDate;
    // 유저의 메이저 정보를 포함
    private LoginResponseDto memberReadDto;
    // 게시글의 메이저 정보를 포함 (유저의 메이저와 게시글의 메이저가 다를 수 있으므로)
    private Major boardMajor;
}
