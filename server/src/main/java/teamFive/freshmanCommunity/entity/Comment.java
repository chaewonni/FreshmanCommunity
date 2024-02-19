package teamFive.freshmanCommunity.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import teamFive.freshmanCommunity.dto.CommentDto;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column
    private LocalDateTime createDate;

    @Column
    @ColumnDefault("0") //기본값 0
    private int likesCount;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name="article_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Article article;

    public static Comment createNewComment(CommentDto dto, Article article, Member member){
        //API로 content만 전달됨
        //처음 comment 만들면 좋아요개수 자동 0개
        return new Comment(
                dto.getId(),
                dto.getContent(),
                LocalDateTime.now(),
                0,
                member,
                article);
    }

    public void patch(CommentDto dto) {
        if(this.content != dto.getContent())
            this.content = dto.getContent();
    }
}
