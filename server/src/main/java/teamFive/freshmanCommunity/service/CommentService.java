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
import teamFive.freshmanCommunity.exception.CommentNotFoundException;
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
        //dto로 변환해서 반환
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentResponseDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentResponseDto create(Long articleId, CommentRequestDto dto, Member member) {
        //api로 content만
        Article article = articleRepository.findById(articleId)
                .orElseThrow(()-> new BoardNotFoundByIdException());

        Comment created = Comment.createNewComment(dto, article, member);  //likesCount는 처음생성하면 0개니까 자동생성되도록
        Comment save = commentRepository.save(created);
        return CommentResponseDto.createCommentDto(save);
    }

    @Transactional
    public CommentResponseDto update(Long commentId, CommentRequestDto dto) {
        Comment target = commentRepository.findById(commentId)
                .orElseThrow(()->new CommentNotFoundException());
        //수정사항 content 밖에 없음
        target.patch(dto);
        Comment save = commentRepository.save(target);
        return CommentResponseDto.createCommentDto(save);
    }

    @Transactional
    public CommentResponseDto delete(Long commentId) {
        Comment target = commentRepository.findById(commentId)
                .orElseThrow(()-> new CommentNotFoundException());
        commentRepository.delete(target);
        return CommentResponseDto.createCommentDto(target);
    }
}
