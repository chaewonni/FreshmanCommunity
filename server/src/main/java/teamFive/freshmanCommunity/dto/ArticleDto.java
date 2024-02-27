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
        // 게시글에 연결된 회원 정보가 있으면 MemberInfoDto 객체를 생성, 없으면 memberInfo를 null로 설정
        MemberInfoDto memberInfo = n.getMember() != null ?
                MemberInfoDto.createMemberDto(n.getMember()) : null;

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
