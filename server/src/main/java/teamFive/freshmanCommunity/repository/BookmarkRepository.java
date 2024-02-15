package teamFive.freshmanCommunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teamFive.freshmanCommunity.entity.Article;
import teamFive.freshmanCommunity.entity.Bookmark;
import teamFive.freshmanCommunity.entity.Member;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    Bookmark findByMemberAndArticle(Member member, Article article);

    void deleteByMemberAndArticle(Member member, Article article);

    List<Bookmark> findAllByMemberOrderByCreateDateDesc(Member member);
}
