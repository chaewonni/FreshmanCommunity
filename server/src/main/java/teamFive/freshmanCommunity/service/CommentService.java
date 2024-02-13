package teamFive.freshmanCommunity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teamFive.freshmanCommunity.dto.CommentDto;
import teamFive.freshmanCommunity.entity.Article;
import teamFive.freshmanCommunity.entity.Comment;
import teamFive.freshmanCommunity.entity.Member;
import teamFive.freshmanCommunity.exception.BoardNotFoundByIdException;
import teamFive.freshmanCommunity.exception.BoardNotFoundException;
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

    public List<CommentDto> comments(Long articleId) {
        //articleId가 없을 경우 에러
        if(articleRepository.findById(articleId).isEmpty())
            throw new BoardNotFoundByIdException();
        //dto로 변환해서 반환
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDto create(Long articleId, CommentDto dto, Member member) {
        //api로 content만
        Article article = articleRepository.findById(articleId)
                .orElseThrow(()-> new BoardNotFoundByIdException());

        Comment created = Comment.createNewComment(dto, article, member);  //likesCount는 처음생성하면 0개니까 자동생성되도록
        Comment save = commentRepository.save(created);
        return CommentDto.createCommentDto(save);
    }

    @Transactional
    public CommentDto update(Long commentId, CommentDto dto) {
        Comment target = commentRepository.findById(commentId)
                .orElseThrow(()->new CommentNotFoundException());
        //수정사항 content 밖에 없음
        target.patch(dto);
        Comment save = commentRepository.save(target);
        return CommentDto.createCommentDto(save);
    }

    @Transactional
    public CommentDto delete(Long commentId) {
        Comment target = commentRepository.findById(commentId)
                .orElseThrow(()-> new CommentNotFoundException());
        commentRepository.delete(target);
        return CommentDto.createCommentDto(target);
    }
}
