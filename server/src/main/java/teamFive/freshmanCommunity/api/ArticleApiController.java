package teamFive.freshmanCommunity.api;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import teamFive.freshmanCommunity.dto.ArticleDto;
import teamFive.freshmanCommunity.entity.Article;
import teamFive.freshmanCommunity.repository.ArticleRepository;
import teamFive.freshmanCommunity.service.ArticleService;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@AllArgsConstructor
public class ArticleApiController {
    @Autowired
    private ArticleService articleService;

    //1. 게시글 조회
    @GetMapping("/articles/{majorId}")
    public ResponseEntity<List<ArticleDto>> showAll(@PathVariable Long majorId) {
        // 서비스에 위임
        List<ArticleDto> dtos = articleService.articles(majorId);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
}
