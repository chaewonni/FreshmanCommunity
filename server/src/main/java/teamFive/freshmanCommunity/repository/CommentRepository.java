package teamFive.freshmanCommunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import teamFive.freshmanCommunity.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    //게시글 id로 모든 댓글 찾기
    @Query(value="SELECT * FROM comment WHERE article_id = :articleId", nativeQuery = true)
    List<Comment> findByArticleId(Long articleId);

    //댓글 좋아요 10개 넘으면 맨 위로
    @Query(value = "SELECT * FROM comment " +
            "WHERE article_id = :articleId " +
            "ORDER BY CASE WHEN likes >= 10 THEN 0 ELSE 1 END, likesCount DESC",    //0인 댓글들 먼저 정렬하고
            nativeQuery = true)
    List<Comment> findAllOrderByLikes(Long articleId);
}
