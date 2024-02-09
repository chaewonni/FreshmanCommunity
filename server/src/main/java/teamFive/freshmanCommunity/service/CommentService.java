package teamFive.freshmanCommunity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teamFive.freshmanCommunity.dto.CommentDto;
import teamFive.freshmanCommunity.entity.Article;
import teamFive.freshmanCommunity.entity.Comment;
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
        //dto로 변환해서 반환
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {
        //api로 content만 들어오고, uri로 articleId
        Article article = articleRepository.findById(articleId)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        Comment created = Comment.createNewComment(dto, article);  //likesCount는 처음생성하면 0개니까 자동생성되도록
        Comment save = commentRepository.save(created);
        return CommentDto.createCommentDto(save);
    }

    @Transactional
    public CommentDto update(Long commentId, CommentDto dto) {
        //api로 content만 들어옴
        Comment target = commentRepository.findById(commentId)
                .orElseThrow(()->new IllegalArgumentException("해당 id의 댓글이 존재하지 않습니다."));
        target.patch(dto);
        Comment save = commentRepository.save(target);
        return CommentDto.createCommentDto(save);
    }

    @Transactional
    public CommentDto delete(Long commentId) {
        Comment target = commentRepository.findById(commentId)
                .orElseThrow(()-> new IllegalArgumentException("해당 id의 댓글이 존재하지 않습니다."));
        commentRepository.delete(target);
        return CommentDto.createCommentDto(target);
    }
}
