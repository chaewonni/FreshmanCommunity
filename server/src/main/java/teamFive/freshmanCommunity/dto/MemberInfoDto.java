package teamFive.freshmanCommunity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import teamFive.freshmanCommunity.entity.Major;
import teamFive.freshmanCommunity.entity.Member;

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

    public static MemberInfoDto createMemberDto(Member member){
        return new MemberInfoDto(
                member.getId(),
                member.getMemberName(),
                member.getStudentId(),
                member.getMajor()
        );
    }
}
