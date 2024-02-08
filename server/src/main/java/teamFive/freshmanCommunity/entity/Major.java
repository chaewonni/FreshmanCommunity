package teamFive.freshmanCommunity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Major {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "majorId")
    private Long id;

    @Column
    private String majorName;
}
