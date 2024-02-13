package teamFive.freshmanCommunity.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import teamFive.freshmanCommunity.dto.CreateArticleDto;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String content;
    @CreationTimestamp
    @Column
    private LocalDateTime createDate;
    @ManyToOne
    @JoinColumn(name="memberId")
    private Member member;

    public static Article create(CreateArticleDto dto, Member member) {

        return new Article(
                null,
                dto.getTitle(),
                dto.getContent(),
                null,
                member
        );
    }
}
