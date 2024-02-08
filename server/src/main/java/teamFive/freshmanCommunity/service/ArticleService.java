package teamFive.freshmanCommunity.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamFive.freshmanCommunity.dto.ArticleDto;
import teamFive.freshmanCommunity.entity.Article;
import teamFive.freshmanCommunity.exception.NonExistentBoardIdException;
import teamFive.freshmanCommunity.repository.ArticleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<ArticleDto> articles(Long majorId) {
        // 0.5. majorId 존재 안할 시 예외 처리 : 몇 번이 무슨 학과인지, 몇 번까지 있는지는 한 번 찾아봐야 할 것 같습니다.
        if (majorId <0 || majorId > 90) {
            throw new NonExistentBoardIdException();
        }
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
