package teamFive.freshmanCommunity.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import teamFive.freshmanCommunity.dto.ArticleCreateDto;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
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
                null,
                dto.getTitle(),
                dto.getContent(),
                0,
                null,
                member,
                major
        );
    }
}
