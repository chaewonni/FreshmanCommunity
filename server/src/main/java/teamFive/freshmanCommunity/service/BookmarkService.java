package teamFive.freshmanCommunity.service;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import teamFive.freshmanCommunity.dto.BookmarkDto;
import teamFive.freshmanCommunity.entity.Article;
import teamFive.freshmanCommunity.entity.Bookmark;
import teamFive.freshmanCommunity.entity.Member;
import teamFive.freshmanCommunity.exception.BoardNotFoundException;
import teamFive.freshmanCommunity.repository.ArticleRepository;
import teamFive.freshmanCommunity.repository.BookmarkRepository;

@Service
@RequiredArgsConstructor
public class BookmarkService {

    private final ArticleService articleService;
    private final ArticleRepository articleRepository;
    private final BookmarkRepository bookmarkRepository;

    @Transactional
    public BookmarkDto addBookmark(Long articleId, HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        Article article = articleRepository.findById(articleId).
                orElseThrow(() -> new BoardNotFoundException());

        if(bookmarkRepository.findByMemberAndArticle(member, article) == null) {
            article.setBookmarkCount(article.getBookmarkCount()+1);
            Bookmark bookmark = Bookmark.createBookmark(member, article);
            bookmarkRepository.save(bookmark);
            return BookmarkDto.createBookmarkDto("북마크 처리 완료", bookmark);
        }
        else {
            article.setBookmarkCount(article.getBookmarkCount()-1);
            Bookmark bookmark = bookmarkRepository.findByMemberAndArticle(member, article);
            bookmark.deleteBookmark(article); //false처리
            bookmarkRepository.deleteByMemberAndArticle(member, article);
            return BookmarkDto.createBookmarkDto("북마크 취소 완료", bookmark);
        }
    }
}
