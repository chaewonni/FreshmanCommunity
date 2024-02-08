package teamFive.freshmanCommunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import teamFive.freshmanCommunity.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query(value = "SELECT * FROM article",
        nativeQuery = true)
    Article showAll();
}
