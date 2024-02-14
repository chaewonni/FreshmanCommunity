package teamFive.freshmanCommunity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@NoArgsConstructor
@Getter
@ToString
@Entity
public class LikeComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id")
    @OnDelete(action= OnDeleteAction.CASCADE) //멤버가 지워지면, likeComment 릴레이션도 삭제됨
    private Member member;

    @ManyToOne
    @JoinColumn(name="comment_id")
    private Comment comment;

    public Like(Member member, Comment comment){
        this.member = member;
        this.comment = comment;
    }
}
