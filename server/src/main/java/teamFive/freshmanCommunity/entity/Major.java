package teamFive.freshmanCommunity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Major {
    @Id
    private Long id;
}
