package teamFive.freshmanCommunity.api;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teamFive.freshmanCommunity.dto.ArticleReadDto;
import teamFive.freshmanCommunity.dto.ArticleCreateDto;
import teamFive.freshmanCommunity.entity.Article;
import teamFive.freshmanCommunity.exception.ArticleNotFoundException;
import teamFive.freshmanCommunity.exception.MajorConflictWithArticleException;
import teamFive.freshmanCommunity.service.ArticleService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ArticleApiController {
    @Autowired
    private ArticleService articleService;

    //1-1. 게시글 전체 조회
    @GetMapping("/articles/{majorId}")
    public ResponseEntity<List<ArticleReadDto>> showAll(@PathVariable Long majorId) {
        // 서비스에 위임
        List<ArticleReadDto> dtos = articleService.articles(majorId);
        // 예외 처리
        if (dtos == null) {
            throw new ArticleNotFoundException();
        }
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    //1-2. 게시글 하나 조회
    @GetMapping("/articles/{majorId}/{articleId}")
    public ResponseEntity<ArticleReadDto> showOne(@PathVariable Long articleId) {
        // 서비스에 위임
        ArticleReadDto dto = articleService.oneArticle(articleId);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    //2. 게시글 생성
    @PostMapping("/articles/{majorId}")
    public ResponseEntity<ArticleReadDto> create(@PathVariable Long majorId,
                                             @RequestBody ArticleCreateDto dto,
                                             HttpServletRequest request) {
        ArticleReadDto createdDto = articleService.create(majorId, dto, request);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    // 3. 게시글 수정
    @PatchMapping("/articles/{majorId}/{articleId}")
    public ResponseEntity<ArticleReadDto> update(@PathVariable Long articleId,
                                                 @RequestBody ArticleCreateDto dto,
                                                 HttpServletRequest request) {
        ArticleReadDto updatedDto = articleService.update(articleId, dto, request);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

    // 4. 게시글 삭제
    @DeleteMapping("/articles/{majorId}/{articleId}")
    public ResponseEntity<ArticleReadDto> delete(@PathVariable Long majorId,
                                                 @PathVariable Long articleId){
        // 서비스에 위임
        ArticleReadDto deletedDto = articleService.delete(majorId, articleId);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }


}
