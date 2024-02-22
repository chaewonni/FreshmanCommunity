package teamFive.freshmanCommunity.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
    @Column(name = "member_id")
    private Long id;

    @Column
    private String memberName;

    @Column
    private String studentId;

    @Column
    private String email;

    @Column
    private String password;

    //학과 정보
    @ManyToOne
    @JoinColumn(name = "major_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Major major;


    //엔티티 생성
    public static Member createMember(SignupDto signupDto, Major major) {
        //예외 발생
        if(!signupDto.getMajorName().equals(major.getMajorName()))
            throw new IllegalArgumentException("name이 잘못됐습니다.");

//        프론트에서 전체 학번을 받고, 백엔드에서 2자리로 만들어서 저장하는 형태
//        String studentId = signupDto.getStudentId();
//        String processStudentId = studentId.substring(0,2);


//        처음부터 2자리 숫자만 프론트엔드에서 받도록 하고, 백엔드에선 substring 대신 string 길이로 2자리수 판단 후 저장하는 형태
        String studentId = signupDto.getStudentId();

        if(studentId.length() != 2) {
            throw new IllegalArgumentException("학번의 길이가 2자리가 아닙니다.");
        }

        return new Member(
                null,
                signupDto.getMemberName(),
                studentId,
                signupDto.getEmail(),
                signupDto.getPassword(),
                major
        );
    }

    public void clearPassword() {
        this.password = "";
    }
}