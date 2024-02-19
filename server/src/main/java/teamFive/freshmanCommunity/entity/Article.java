package teamFive.freshmanCommunity.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import teamFive.freshmanCommunity.dto.ArticleCreateDto;
import teamFive.freshmanCommunity.exception.IdConflictWithDtoException;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Slf4j
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private int bookmarkCount;

    @CreationTimestamp
    @Column
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name="major_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Major major;

    public static Article create(ArticleCreateDto dto, Major major, Member member) {

        return new Article(
                dto.getId(),
                dto.getTitle(),
                dto.getContent(),
                0,
                null,
                member,
                major
        );
    }

    public void patch(ArticleCreateDto dto) {
        log.info(this.getId() + " " + dto.getId());
        // 예외 발생
        if (this.getId() != dto.getId()) {
            throw new IdConflictWithDtoException();
        }
        // 수정
        if (this.getTitle() != dto.getTitle()) {
            this.setTitle(dto.getTitle());
        }
        if (this.getContent() != dto.getContent()) {
            this.setContent(dto.getContent());
        }
    }
}
