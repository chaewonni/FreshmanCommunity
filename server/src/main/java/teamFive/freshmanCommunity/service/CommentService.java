package teamFive.freshmanCommunity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teamFive.freshmanCommunity.dto.CommentRequestDto;
import teamFive.freshmanCommunity.dto.CommentResponseDto;
import teamFive.freshmanCommunity.entity.Article;
import teamFive.freshmanCommunity.entity.Comment;
import teamFive.freshmanCommunity.entity.Member;
import teamFive.freshmanCommunity.exception.BoardNotFoundByIdException;
import teamFive.freshmanCommunity.exception.CommentMissingContentException;
import teamFive.freshmanCommunity.exception.CommentNotFoundException;
import teamFive.freshmanCommunity.exception.NotSameMemberException;
import teamFive.freshmanCommunity.repository.ArticleRepository;
import teamFive.freshmanCommunity.repository.CommentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentResponseDto> comments(Long articleId) {
        //articleId가 없을 경우 에러
        if(articleRepository.findById(articleId).isEmpty())
            throw new BoardNotFoundByIdException();
        //dto로 변환해서 반환(10개 이상시 맨 위로 올라가도록)
        return commentRepository.findByArticleIdOrderByLikes(articleId)
                .stream()
                .map(comment -> CommentResponseDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentResponseDto create(Long articleId, CommentRequestDto dto, Member member) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(()-> new BoardNotFoundByIdException());

        //추가하는 댓글의 content가 없으면 오류
        if(dto.getContent().isBlank())
            throw new CommentMissingContentException();

        Comment created = Comment.createNewComment(dto, article, member);
        Comment save = commentRepository.save(created);
        return CommentResponseDto.createCommentDto(save);
    }

    @Transactional
    public CommentResponseDto update(Long commentId, CommentRequestDto dto, Member member) {
        Comment target = commentRepository.findById(commentId)
                .orElseThrow(()->new CommentNotFoundException());
        //지우려는 댓글이 로그인한 유저가 아닌 경우 수정 불가
        if(!target.getMember().getId().equals(member.getId()))
            throw new NotSameMemberException();
        //수정 댓글의 content가 없으면 오류
        if(dto.getContent().isBlank())
            throw new CommentMissingContentException();

        target.patch(dto);
        Comment save = commentRepository.save(target);
        return CommentResponseDto.createCommentDto(save);
    }

    @Transactional
    public void delete(Long commentId, Member member) {
        Comment target = commentRepository.findById(commentId)
                .orElseThrow(()-> new CommentNotFoundException());
        //지우려는 댓글이 로그인한 유저가 아닌 경우 삭제 불가
        if(!target.getMember().getId().equals(member.getId()))
            throw new NotSameMemberException();

        commentRepository.delete(target);
    }
}
