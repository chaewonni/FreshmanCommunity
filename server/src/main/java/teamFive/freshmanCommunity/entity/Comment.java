package teamFive.freshmanCommunity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import teamFive.freshmanCommunity.dto.CommentRequestDto;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
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
    private Article article;

    public static Comment createNewComment(CommentRequestDto dto, Article article, Member member){
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

    public void patch(CommentRequestDto dto) {
        if(this.content != dto.getContent())
            this.content = dto.getContent();
    }
}
