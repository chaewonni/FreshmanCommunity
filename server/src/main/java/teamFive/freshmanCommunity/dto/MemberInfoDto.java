package teamFive.freshmanCommunity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import teamFive.freshmanCommunity.entity.Major;
import teamFive.freshmanCommunity.entity.Member;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemberInfoDto {
    private Long id;
    private String memberName;
    private String studentId;
    private Major major;

    // Member 객체로부터 MemberInfoDto를 생성하는 메소드
    public static MemberInfoDto createMemberDto(Member member){
        return new MemberInfoDto(
                member.getId(), // 회원 ID
                member.getMemberName(), // 회원 이름
                member.getStudentId(), // 학번
                member.getMajor() // 전공
        );
    }
}
