package teamFive.freshmanCommunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import teamFive.freshmanCommunity.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    //댓글 좋아요 10개 넘으면 우선순위로 가져오기
    @Query(value = "SELECT * FROM comment WHERE article_id = :articleId " +
            "ORDER BY CASE WHEN likes_count >= 10 THEN 0 ELSE 1 END, " +    //좋아요 10개 이상인 경우 먼저 보이고
            "create_date ASC",    //나머지 생성시간순
            nativeQuery = true )    //SQL문으로 사용
    List<Comment> findByArticleIdOrderByLikes(Long articleId);
}
