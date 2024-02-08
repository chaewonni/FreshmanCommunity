package teamFive.freshmanCommunity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity
public class LikeComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean status;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name="comment_id")
    private Comment comment;
}
