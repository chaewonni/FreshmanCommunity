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
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

        Comment created = Comment.createComment(dto, article);
        Comment save = commentRepository.save(created);
        //likeCount 처리해야함!
        return CommentDto.createCommentDto(save);
    }
}
