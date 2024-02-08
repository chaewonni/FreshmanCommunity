package teamFive.freshmanCommunity.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamFive.freshmanCommunity.dto.ArticleDto;
import teamFive.freshmanCommunity.entity.Article;
import teamFive.freshmanCommunity.repository.ArticleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<ArticleDto> articles(Long majorId) {
        // 1. 게시글 조회
        List<Article> articles = articleRepository.findAllByMajor(majorId);
        // 2. 엔티티 -> DTO 반환
        List<ArticleDto> dtos = new ArrayList<ArticleDto>();
        for (Article n : articles) {
            ArticleDto dto = ArticleDto.createArticleDto(n);
            dtos.add(dto);
        }
        // 3. 결과 반환
        return dtos;
    }
}
