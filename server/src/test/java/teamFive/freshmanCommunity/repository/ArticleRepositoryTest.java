package teamFive.freshmanCommunity.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import teamFive.freshmanCommunity.entity.Article;
import teamFive.freshmanCommunity.entity.Major;
import teamFive.freshmanCommunity.entity.Member;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleRepositoryTest {
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void findArticleById() {
    //예상 데이터
    Article article = new Article();
    article.setContent("a");
    article.setTitle("a");
    LocalDateTime date = LocalDateTime.now();
    article.setCreateDate(date);
    //실제 데이터
    Article afterArticle = articleRepository.save(article);
    //비교 및 검증
    assertEquals(afterArticle.getCreateDate(), date);
    }
}