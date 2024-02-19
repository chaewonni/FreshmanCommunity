package teamFive.freshmanCommunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teamFive.freshmanCommunity.entity.Comment;
import teamFive.freshmanCommunity.entity.LikeComment;
import teamFive.freshmanCommunity.entity.Member;

public interface LikeCommentRepository extends JpaRepository<LikeComment, Long> {

    LikeComment findByMemberAndComment(Member member, Comment comment);

    void deleteByMemberAndComment(Member member, Comment comment);
}
