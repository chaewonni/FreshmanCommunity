package teamFive.freshmanCommunity.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String content;
    @Column (name = "TIMESTAMP_FIELD")
    private java.sql.Timestamp createDate;
    @Column
    @ManyToOne
    @JoinColumn(name="memberId")
    private Member member;

    @Column
    @ManyToOne
    @JoinColumn(name="majorId")
    private Major major;
}
