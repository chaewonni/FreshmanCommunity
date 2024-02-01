package teamFive.freshmanCommunity.dto;

import teamFive.freshmanCommunity.entity.Major;
import teamFive.freshmanCommunity.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private Long id;
    private String memberName;
    private Major major;

//    public static LoginResponseDto loginResponseDto(Member member){
//        return new LoginResponseDto(
//                member.getId(),
//                member.getMemberName(),
//                member.getMajor().getMajorName()
//        );
//    }

}
