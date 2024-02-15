package teamFive.freshmanCommunity.repository;

import teamFive.freshmanCommunity.entity.Major;
import teamFive.freshmanCommunity.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);

    Long countByEmail(String email);
}
