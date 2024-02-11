package teamFive.freshmanCommunity.api;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teamFive.freshmanCommunity.dto.CommentDto;
import teamFive.freshmanCommunity.entity.Member;
import teamFive.freshmanCommunity.service.CommentService;

import java.util.List;

@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;

    //전체 댓글 조회
    @GetMapping("/article/{articleId}/comment")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long articleId){
        List<CommentDto> dtos = commentService.comments(articleId);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
        //null이어도 오류 아님.
    }

    @PostMapping("/article/{articleId}/comment")
    public ResponseEntity<CommentDto> create(@PathVariable Long articleId, @RequestBody CommentDto dto, HttpSession session){
        //세션에서 member 불러오기
        Member member = (Member) session.getAttribute("member");

        CommentDto createDto = commentService.create(articleId, dto, member);
        return ResponseEntity.status(HttpStatus.OK).body(createDto);
    }

    @PatchMapping("/comment/{commentId}")
    public ResponseEntity<CommentDto> update(@PathVariable Long commentId, @RequestBody CommentDto dto){
        CommentDto target = commentService.update(commentId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(target);
    }

    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<CommentDto> delete(@PathVariable Long commentId){
        CommentDto deleteDto = commentService.delete(commentId);
        return ResponseEntity.status(HttpStatus.OK).body(deleteDto);
    }
}
