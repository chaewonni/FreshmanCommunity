import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { login } from '../../apis/login';
import './login.css';

export default function Login() {
  const navigate = useNavigate();

  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const [emailValid, setEmailValid] = useState(false);
  const [passwordValid, setPasswordValid] = useState(false);

  const [notAllow, setNotAllow] = useState(true);

  const handleEmail = e => {
    setEmail(e.target.value);
    const regex =
      /^(([^<>()[\].,;:\s@"]+(\.[^<>()[\].,;:\s@"]+)*)|(".+"))@(([^<>()[\].,;:\s@"]+\.)+[^<>()[\].,;:\s@"]{2,})$/i;
    if (regex.test(email)) {
      setEmailValid(true);
    } else {
      setEmailValid(false);
    }
  };

  const handlePassword = e => {
    setPassword(e.target.value);
    const regex = /^(?=.*[a-zA-Z\d@$!%*?&]).*$/;

    if (regex.test(e.target.value)) {
      setPasswordValid(true);
    } else {
      setPasswordValid(false);
    }
  };

  const onClickConfirmButton = () => {
    navigate('/');
    // try {
    //   const result = await login(email, password);
    //   const { statusCode, message, jwtAccessToken, jwtRefreshToken, id, memberName, studentId, major } = result;

    //   if (statusCode === 200) {
    //     // 로그인 성공 시의 동작 수행
    //     localStorage.setItem('access', jwtAccessToken);
    //     localStorage.setItem('refresh', jwtRefreshToken);

    //     alert('환영합니다!');

    //     // 여기서 id, memberName, studentId, major 등을 활용하여 필요한 작업 수행
    //     console.log(`로그인 성공! id: ${id}, 이름: ${memberName}, 학번: ${studentId}, 전공: ${major.majorName}`);
    //     navigate('/');
    //   } else if (statusCode === 401) {
    //     alert('비밀번호가 맞지 않습니다.');
    //   } else if (statusCode === 404) {
    //     alert('존재하지 않는 회원입니다.');
    //   } else {
    //     // 기타 상황에 대한 처리
    //     console.warn(`알 수 없는 상태 코드: ${statusCode}, 메시지: ${message}`);
    //   }
    // } catch (error) {
    //   // 에러 처리
    //   console.error('로그인 요청 중 오류:', error);

    //   // 전체 에러 객체를 로그로 출력하여 구조를 검사
    //   console.log('전체 에러 객체:', error);

    //   // 필요한 경우 추가 디버깅 단계를 추가하세요
  };

  const onClickRegisterButton = () => {
    navigate('/user/signup');
  };

  useEffect(() => {
    if (emailValid && passwordValid) {
      setNotAllow(false);
      return;
    }
    setNotAllow(true);
  }, [emailValid, passwordValid]);

  return (
    <div>
      <div className="container">
        {/* 로그인 , ewha where change begins */}
        <div id="top-text">
          <h1>로그인</h1>
          <h3>
            EWHA <span>| Where Change Begins</span>
          </h3>
        </div>

        {/* 입력 창  */}
        <form className="input">
          <div className="email-input">
            <span>Email*</span>
            <input
              type="email"
              placeholder="이메일을 입력해주세요."
              value={email}
              onChange={handleEmail}
              required></input>
            <div className="errorMessageWrap">
              {!emailValid && email.length > 0 && <span>올바른 이메일을 입력해주세요.</span>}
            </div>
          </div>

          <div className="password-input">
            <span>Password*</span>
            <input
              type="password"
              placeholder="비밀번호를 입력해주세요."
              value={password}
              onChange={handlePassword}
              required></input>
            <div className="errorMessageWrap">
              {!passwordValid && password.length > 0 && <span>영문, 숫자, 특수문자 중 최소 하나를 입력해주세요.</span>}
            </div>
          </div>
        </form>

        {/* 로그인, 회원가입  */}
        <div className="button">
          {/* 로그인 버튼  */}
          <button disabled={notAllow} onClick={onClickConfirmButton} id="login-button">
            로그인하기
          </button>

          {/* 회원가입  */}
          <div id="join">
            <span>아직 계정이 없으신가요?</span>
            <button onClick={onClickRegisterButton} id="register-button">
              회원가입 하기
            </button>
          </div>
        </div>
      </div>

      <div id="ewha-pic">
        <img src="https://t1.daumcdn.net/cfile/tistory/1809261E4C030E0085" alt="ewha-pic" />
      </div>
    </div>
  );
}
