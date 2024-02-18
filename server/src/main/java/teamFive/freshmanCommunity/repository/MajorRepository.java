package teamFive.freshmanCommunity.repository;

import teamFive.freshmanCommunity.entity.Major;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface MajorRepository extends JpaRepository<Major, Long> {
    //이름으로 조회
    Major findByMajorName(String majorName);
}
