package teamFive.freshmanCommunity.api;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teamFive.freshmanCommunity.dto.CommentRequestDto;
import teamFive.freshmanCommunity.dto.CommentResponseDto;
import teamFive.freshmanCommunity.entity.Member;
import teamFive.freshmanCommunity.exception.MemberNotFoundException;
import teamFive.freshmanCommunity.service.CommentService;

import java.util.List;

@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;

    //전체 댓글 조회
    @GetMapping("/article/{articleId}/comment")
    public ResponseEntity<List<CommentResponseDto>> comments(@PathVariable Long articleId){
        List<CommentResponseDto> dtos = commentService.comments(articleId);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @PostMapping("/article/{articleId}/comment")
    public ResponseEntity<CommentResponseDto> create(@PathVariable Long articleId, @RequestBody CommentRequestDto dto, HttpSession session){
        //세션에서 member 불러오기
        Member member = (Member) session.getAttribute("member");
        if (member == null) throw new MemberNotFoundException("멤버 조회 실패");

        CommentResponseDto createDto = commentService.create(articleId, dto, member);
        return ResponseEntity.status(HttpStatus.OK).body(createDto);
    }

    @PatchMapping("/comment/{commentId}")
    public ResponseEntity<CommentResponseDto> update(@PathVariable Long commentId, @RequestBody CommentRequestDto dto){
        CommentResponseDto target = commentService.update(commentId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(target);
    }

    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<CommentResponseDto> delete(@PathVariable Long commentId){
        CommentResponseDto deleteDto = commentService.delete(commentId);
        return ResponseEntity.status(HttpStatus.OK).body(deleteDto);
    }
}
