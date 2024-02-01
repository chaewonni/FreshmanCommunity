package teamFive.freshmanCommunity.entity;

import teamFive.freshmanCommunity.dto.SignupDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor //모든 필드를 매개변수로 갖는 생성자 자동 생성
@NoArgsConstructor //매개변수가 아예 없는 기본 생성자 자동 생성
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId")
    private Long id;

    @Column
    private String memberName;

    @Column
    private String studentId;

    @Column
    private String email;

//    @JsonIgnore //데이터의 이동에서 민감정보인 password를 숨기기 위해
    @Column
    private String password;

    //학과 정보
    @ManyToOne
    @JoinColumn(name = "majorId")
    private Major major;


    //엔티티 생성
    public static Member createMember(SignupDto signupDto, Major major) {
        //예외 발생
        if(signupDto.getId() != null)
            throw new IllegalArgumentException("member의 id가 없어야 합니다.");
        if(!signupDto.getMajorName().equals(major.getMajorName()))
            throw new IllegalArgumentException("name이 잘못됐습니다.");

        String studentId = signupDto.getStudentId();
        String processStudentId = studentId.substring(0,2);

        return new Member(
                signupDto.getId(),
                signupDto.getMemberName(),
                processStudentId,
                signupDto.getEmail(),
                signupDto.getPassword(),
                major
        );
    }

    public void clearPassword() {
        this.password = "";
    }
}
