package teamFive.freshmanCommunity.service;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamFive.freshmanCommunity.dto.ArticleDto;
import teamFive.freshmanCommunity.dto.ArticleCreateDto;
import teamFive.freshmanCommunity.dto.ArticleReadDto;
import teamFive.freshmanCommunity.entity.Article;
import teamFive.freshmanCommunity.entity.Major;
import teamFive.freshmanCommunity.entity.Member;
import teamFive.freshmanCommunity.exception.ArticleNotFoundException;
import teamFive.freshmanCommunity.exception.BoardNotFoundByIdException;
import teamFive.freshmanCommunity.exception.BoardNotFoundException;
import teamFive.freshmanCommunity.exception.MemberNotFoundException;
import teamFive.freshmanCommunity.repository.ArticleRepository;
import teamFive.freshmanCommunity.repository.MajorRepository;
import teamFive.freshmanCommunity.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private MajorRepository majorRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public ArticleReadDto create(Long majorId, ArticleCreateDto dto, HttpServletRequest request) {
        // 1-1. 학과 조회 및 예외 발생
        Major major = majorRepository.findById(majorId)
                .orElseThrow(() -> new BoardNotFoundException());
        // 1-2. 로그인에서 멤버 정보 조회 및 예외 발생
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("member");
        if (member == null) throw new MemberNotFoundException("멤버 조회 실패");
        // 2. 게시글 엔티티 생성
        Article article = Article.create(dto, major, member);
        // 3. 게시글 엔티티를 db에 저장
        Article created = articleRepository.save(article);
        // 4. dto로 변환해 리턴
        return ArticleDto.createArticleReadDto(created);
    }

    public List<ArticleReadDto> articles(Long majorId) {
        // 0.5. majorId 존재 안할 시 예외 처리 : 몇 번이 무슨 학과인지, 몇 번까지 있는지는 한 번 찾아봐야 할 것 같습니다.
        if (majorId <0 || majorId > 90) {
            throw new BoardNotFoundException();
        }
        // 1. 게시글 조회
        List<Article> articles = articleRepository.findAllByMajor(majorId);
        // 2. 엔티티 -> DTO 반환
        List<ArticleReadDto> dtos = new ArrayList<ArticleReadDto>();
        for (Article n : articles) {
            ArticleReadDto dto = ArticleDto.createArticleReadDto(n);
            dtos.add(dto);
        }
        // 3. 결과 반환
        return dtos;
    }

    public ArticleReadDto oneArticle(Long articleId) {
        // 1. 게시글 조회
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new ArticleNotFoundException());
        // 2. 엔티티 -> DTO 반환
        ArticleReadDto dto = ArticleDto.createArticleReadDto(article);
        // 3. 결과 반환
        return dto;
    }
}
