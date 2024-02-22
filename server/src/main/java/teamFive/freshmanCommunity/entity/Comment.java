package teamFive.freshmanCommunity.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import teamFive.freshmanCommunity.dto.CommentRequestDto;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private String createDate;
    @PrePersist //해당 엔티티를 저장하기 이전에 실행
    public void datePrePersist(){
        this.createDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Column
    @ColumnDefault("0") //기본값 0
    private int likesCount;

    @ManyToOne
    @JoinColumn(name="member_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Member member;

    @ManyToOne
    @JoinColumn(name="article_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Article article;

    public static Comment createNewComment(CommentRequestDto dto, Article article, Member member){
        //API로 content만 전달됨
        //처음 comment 만들면 좋아요개수 자동 0개
        return new Comment(
                dto.getId(),
                dto.getContent(),
                null,
                0,
                member,
                article);
    }

    public void patch(CommentRequestDto dto) {
        if(this.content != dto.getContent())
            this.content = dto.getContent();
    }
}
