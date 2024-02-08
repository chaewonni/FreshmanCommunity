package teamFive.freshmanCommunity.repository;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import teamFive.freshmanCommunity.entity.Article;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query(value = "SELECT * FROM article where major_id = :major_id",
        nativeQuery = true)
    List<Article> findAllByMajor(Long major_id);
}
