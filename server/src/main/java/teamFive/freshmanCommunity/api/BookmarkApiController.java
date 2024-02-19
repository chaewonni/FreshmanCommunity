package teamFive.freshmanCommunity.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import teamFive.freshmanCommunity.dto.BookmarkDto;
import teamFive.freshmanCommunity.service.BookmarkService;

@RestController
@RequiredArgsConstructor
public class BookmarkApiController {

    private final BookmarkService bookmarkService;

    //나의 북마크
    @PostMapping("/article/{articleId}/bookmark")
    public ResponseEntity<BookmarkDto> addBookmark(@PathVariable Long articleId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        BookmarkDto bookmark = bookmarkService.addBookmark(articleId, session);
        return ResponseEntity.status(HttpStatus.OK).body(bookmark);
    }
}
