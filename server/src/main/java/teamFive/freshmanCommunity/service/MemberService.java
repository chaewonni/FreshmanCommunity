package teamFive.freshmanCommunity.service;

import teamFive.freshmanCommunity.dto.LoginDto;
import teamFive.freshmanCommunity.dto.SignupDto;
import teamFive.freshmanCommunity.entity.Major;
import teamFive.freshmanCommunity.entity.Member;
import teamFive.freshmanCommunity.exception.DuplicateMemberException;
import teamFive.freshmanCommunity.exception.IncorrectPasswordException;
import teamFive.freshmanCommunity.exception.MemberNotFoundException;
import teamFive.freshmanCommunity.repository.MajorRepository;
import teamFive.freshmanCommunity.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MajorRepository majorRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    //회원가입
    public void signup (SignupDto signupDto) {
        validateDuplicateMember(signupDto);
        signupDto.encodingPassword(passwordEncoder);
        Major major = majorRepository.findByMajorName(signupDto.getMajorName());
        if (major == null) {
            throw new IllegalStateException("전공이 존재하지 않습니다.");
        }
        //멤버 엔티티 생성
        Member member = Member.createMember(signupDto, major);
        //멤버 엔티티를 DB에 저장
        memberRepository.save(member);
    }

    private void validateDuplicateMember(SignupDto signupDto) {
        Long count = memberRepository.countByEmail(signupDto.getEmail());
        if (count > 0) {
            // 중복된 이메일이나 학번이 존재하는 경우 예외 발생
            throw new DuplicateMemberException("이미 존재하는 회원입니다.");
        }
    }

    //로그인
    public Member login (LoginDto loginDto) {
        Member member = memberRepository.findByEmail(loginDto.getEmail());
        if (member == null)
            throw new MemberNotFoundException("존재하지 않는 회원입니다.");
        if (!passwordEncoder.matches(loginDto.getPassword(), member.getPassword()))
            throw new IncorrectPasswordException("비밀번호가 맞지 않습니다.");

        member.clearPassword();
        return member;
    }

    //로그아웃
    public void logout(HttpSession session) {
        if(session.getAttribute("member") != null) {
            session.removeAttribute("member");
            session.invalidate();
        }
    }

    //회원 탈퇴
    public void delete(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));
        memberRepository.delete(member);
    }

}
