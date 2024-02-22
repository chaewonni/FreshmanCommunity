import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { login } from '../../apis/login';
import './login.css';

export default function Login() {
  const navigate = useNavigate();

  const [email, setEmail] = useState('');
  const [password, setpassword] = useState('');
  const [emailValid, setEmailValid] = useState(false);
  const [passwordValid, setpasswordValid] = useState(false);

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

  const handlepassword = e => {
    setpassword(e.target.value);
    const regex =
      /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+])(?!.*[^a-zA-z0-9$`~!@$!%*#^?&\\(\\)\-_=+]).{8,20}$/;
    if (regex.test(password)) {
      setpasswordValid(true);
    } else {
      setpasswordValid(false);
    }
  };

  // const onClickConfirmButton = () => {
  //   if(email === User.email && password === User.password) {
  //     alert('로그인에 성공');
  //     navigate("/main");
  //   } else {
  //     alert('등록되지 않은 회원입니다.');
  //   }
  // }

  const onClickConfirmButton = async () => {
    const result = await login(email, password);
    const { jwtAccessToken, jwtRefreshToken } = result;
    localStorage.setItem('access', jwtAccessToken);
    localStorage.setItem('refresh', jwtRefreshToken);
    navigate('/main');
  };

  const onClickRegisterButton = () => {
    navigate('/users/join');
  };

  useEffect(() => {
    if (emailValid && passwordValid) {
      setNotAllow(false);
      return;
    }
    setNotAllow(true);
  }, [emailValid, passwordValid]);

  return (
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
            onChange={handlepassword}
            required></input>
          <div className="errorMessageWrap">
            {!passwordValid && password.length > 0 && <span>영문, 숫자, 특수문자 포함 8자 이상 입력해주세요.</span>}
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
  );
}
