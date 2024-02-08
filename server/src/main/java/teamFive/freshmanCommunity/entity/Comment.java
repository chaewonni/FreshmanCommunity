package teamFive.freshmanCommunity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import teamFive.freshmanCommunity.dto.CommentDto;

import java.time.LocalDateTime;
import java.util.List;

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

//    @OneToMany
//    @JoinColumn(name="likeComment")
//    private List<LikeComment> likesCount;

    @Column
    private Integer likesCount;
    //리스트형태로 저장? 아니면 그냥 숫자만 저장할지..

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name="article_id")
    private Article article;

    public static Comment createComment(CommentDto dto){
        return new Comment(dto.getId(), dto.getContent(), dto.getCreateDate(), dto.getLikesCount(), dto.getMember(), dto.getArticle());
    }
}
