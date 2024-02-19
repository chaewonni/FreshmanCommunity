package teamFive.freshmanCommunity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import teamFive.freshmanCommunity.entity.Major;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemberInfoDto {
    private Long id;
    private String memberName;
    private String studentId;
    private Major major;
}
