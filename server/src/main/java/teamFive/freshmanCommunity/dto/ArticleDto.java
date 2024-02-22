package teamFive.freshmanCommunity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import teamFive.freshmanCommunity.entity.Article;
import teamFive.freshmanCommunity.entity.Major;
import teamFive.freshmanCommunity.entity.Member;

import java.time.LocalDateTime;
import java.util.Locale;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ArticleDto {
    private Long id;
    private String title;
    private String content;
    private int bookmarkCount;
    private String createDate;
    private Member member;
    private Major major;

    public static ArticleDto createArticleDto(Article created) {
        return new ArticleDto(
                created.getId(),
                created.getTitle(),
                created.getContent(),
                created.getBookmarkCount(),
                created.getCreateDate(),
                created.getMember(),
                created.getMajor()
        );
    }

    public static ArticleReadDto createArticleReadDto(Article n) {
        MemberInfoDto memberInfo = null;

        if(n.getMember() != null) {
            MemberInfoDto dto = MemberInfoDto.createMemberDto(n.getMember());
            memberInfo = new MemberInfoDto(
                    dto.getId(),
                    dto.getMemberName(),
                    dto.getStudentId(),
                    dto.getMajor()
            );
        }

        return new ArticleReadDto(
                n.getId(),
                n.getTitle(),
                n.getContent(),
                n.getBookmarkCount(),
                n.getCreateDate(),
                memberInfo,
                n.getMajor()
        );
    }
}
