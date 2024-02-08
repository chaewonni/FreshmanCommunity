package teamFive.freshmanCommunity.api;

import teamFive.freshmanCommunity.dto.LoginDto;
import teamFive.freshmanCommunity.dto.LoginResponseDto;
import teamFive.freshmanCommunity.dto.SignupDto;
import teamFive.freshmanCommunity.entity.Member;
import teamFive.freshmanCommunity.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teamFive.freshmanCommunity.dto.LoginDto;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    //회원가입
    @PostMapping("/user/signup")
    public ResponseEntity<String> signup(@RequestBody SignupDto signupDto) {
        memberService.signup(signupDto);
        return ResponseEntity.status(HttpStatus.OK).body("회원가입 성공");
    }

    //로그인
    @PostMapping("/user/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto, HttpServletRequest request){
        Member member = memberService.login(loginDto);

        if (member != null) {
            // 로그인 성공
            HttpSession session = request.getSession();
            session.setAttribute("member", member);
            LoginResponseDto response = new LoginResponseDto(member.getId(), member.getMemberName(), member.getMajor());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            // 로그인 실패
//            HttpSession session = request.getSession();
//            session.removeAttribute("member");
//            session.invalidate();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }

    //로그아웃
    @PostMapping("/user/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        memberService.logout(session);
        return ResponseEntity.status(HttpStatus.OK).body("로그아웃 성공");
    }

    //회원탈퇴
    @DeleteMapping("/user/delete")
    public ResponseEntity<String> delete(HttpSession session){
        Member member = (Member) session.getAttribute("member");

        if (member != null){
            memberService.delete(member.getId());
            session.invalidate();
            return ResponseEntity.status(HttpStatus.OK).body("탈퇴 완료");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
