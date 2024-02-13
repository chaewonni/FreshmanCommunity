package teamFive.freshmanCommunity.api;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teamFive.freshmanCommunity.dto.ArticleDto;
import teamFive.freshmanCommunity.dto.ArticleReadDto;
import teamFive.freshmanCommunity.dto.CreateArticleDto;
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
    public ResponseEntity<List<ArticleReadDto>> showAll(@PathVariable Long majorId) {
        // 서비스에 위임
        List<ArticleReadDto> dtos = articleService.articles(majorId);
        // 예외 처리
        if (dtos == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    //2. 게시글 생성
    @PostMapping("/articles/{majorId}")
    public ResponseEntity<ArticleReadDto> create(@PathVariable Long majorId,
                                             @RequestBody CreateArticleDto dto,
                                             HttpServletRequest request) {
        ArticleReadDto createdDto = articleService.create(majorId, dto, request);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }
}
