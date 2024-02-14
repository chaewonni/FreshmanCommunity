package teamFive.freshmanCommunity.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import teamFive.freshmanCommunity.entity.LikeComment;
import teamFive.freshmanCommunity.service.LikeCommentService;

@RestController
@RequiredArgsConstructor
public class LikeCommentApiController {

    private final LikeCommentService likeCommentService;

    @PostMapping("/comment/{commentId}/like")
    public ResponseEntity<String> addLike(@PathVariable Long commentId, HttpServletRequest request) {

        HttpSession session = request.getSession();
        LikeCommentService.addLike(commentId, session);
        return ResponseEntity.status(HttpStatus.OK).body("좋아요 처리 완료");
    }

}
