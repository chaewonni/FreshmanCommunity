package teamFive.freshmanCommunity.dto;

import teamFive.freshmanCommunity.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {
    private String memberName;
    private String studentId;
    private String email;
    private String password;
    private String majorName;

    public static SignupDto createMemberDto(Member member){
        return new SignupDto(
                member.getMemberName(),
                member.getStudentId(),
                member.getEmail(),
                member.getPassword(),
                member.getMajor().getMajorName()
        );
    }

    public void encodingPassword(PasswordEncoder passwordEncoder) {
        if (StringUtils.isEmpty(password)) {
            return;
        }
        password = passwordEncoder.encode(password);
    }

}
