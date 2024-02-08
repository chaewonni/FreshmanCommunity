package teamFive.freshmanCommunity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
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
    @Column
    private LocalDateTime createDate;
    @ManyToOne
    @JoinColumn(name="memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name="majorId")
    private Major major;
}
