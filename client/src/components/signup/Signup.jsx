import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { GoArrowLeft } from 'react-icons/go';
import axios from 'axios';
import { signUp } from '../../apis/signup';
import './signup.css';

export default function Signup() {
  const navigate = useNavigate();
  const [memberName, setMemberName] = useState('');
  const [studentId, setStudentId] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [majorName, setMajorName] = useState('');

  const [emailValid, setEmailValid] = useState(false);
  const [passwordValid, setPasswordValid] = useState(false);
  const [studentIdValid, setStudentIdValid] = useState(false);
  const [majorNameValid, setMajorNameValid] = useState(false);
  const [memberNameValid, setMemberNameValid] = useState(false);

  const [notAllow, setNotAllow] = useState(true);

  // 이름
  const handleMemberName = e => {
    setMemberName(e.target.value);
    const regex = /^[가-힣\s]+$/;
    setMemberNameValid(regex.test(e.target.value));
  };

  // 학번
  const handleStudentId = e => {
    setStudentId(e.target.value);
    // 학번은 2자리 숫자로 이루어진 것으로 가정
    const regex = /^\d{2}$/;
    setStudentIdValid(regex.test(e.target.value));
  };

  // 학과
  const handleMajorName = e => {
    setMajorName(e.target.value);
    // 학과에 대한 유효성 검사를 최소 3글자 이상
    setMajorNameValid(e.target.value.length >= 3);
  };

  // 이메일
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

    setPasswordValid(regex.test(e.target.value));

    // 서버 응답을 받아오기
    const serverResponse = {
      statusCode: 200,
      message: '회원가입 성공',
    };

    if (serverResponse.statusCode === 200) {
      console.log(serverResponse.message);
      // 여기서 적절한 동작을 수행하면 됩니다. 예를 들어, 메시지를 화면에 표시하거나 리다이렉션 등.
    } else if (serverResponse.statusCode === 409) {
      // 이미 존재하는 회원에 대한 처리
      console.log(serverResponse.message);
      alert('이미 존재하는 회원입니다.');
    }
  };

  useEffect(() => {
    if (emailValid && passwordValid && memberNameValid && studentIdValid && majorNameValid) {
      setNotAllow(false);
      return;
    }
    setNotAllow(true);
  }, [emailValid, passwordValid, memberNameValid, studentIdValid, majorNameValid]);

  // const handleAgree = event => {
  //   setChecked(event.target.checked);
  // };

  // const onhandlePost = async data => {
  // const { email, name, password } = data;
  // const postData = { email, name, password };
  //
  // post
  // await axios
  //  .post('/member/join', postData)
  //   .then(response => {
  //   History.push('/login');
  //  })
  // .catch(err => {
  //  console.log(err);
  //   setJoinMessage('회원가입에 실패하였습니다. 모든 정보를 확인해주세요!');
  // });
  // };

  // 뒤로 가기
  const handleBackBtn = () => {
    navigate(-1);
  };

  const handleSignupBtn = async () => {
    await signUp(email, memberName, password, majorName, studentId);
  };

  return (
    <body>
      <div className="signup-container">
        <header>
          <button onClick={handleBackBtn} className="back-btn">
            <GoArrowLeft />
          </button>{' '}
          <h1>회원가입 하기</h1>
        </header>

        <div id="top-text">
          <h3>
            EWHA <span>| Where Change Begins</span>
          </h3>
        </div>

        {/* 입력 창  */}

        <form className="input">
          {/* 이름 */}
          <div className="name-input">
            <span>Name*</span>
            <input
              type="text"
              placeholder="성함을 입력해주세요."
              value={memberName}
              onChange={handleMemberName}
              required></input>
            <div className="errorMessageWrap">
              {!memberNameValid && memberName.length > 0 && <span>올바른 이름을 입력해주세요.</span>}
            </div>
          </div>

          {/* 학번  */}
          <div className="studentId-input">
            <span>Student ID*</span>
            <input
              type="text"
              placeholder="학번을 입력해주세요."
              value={studentId}
              onChange={handleStudentId}
              required></input>
            <div className="errorMessageWrap">
              {!studentIdValid && <span>올바른 학번을 입력해주세요. ex : 24</span>}
            </div>
          </div>

          {/* 학과  */}
          <div className="majorName-input">
            <span>Major*</span>
            <input
              type="text"
              placeholder="학과를 입력해주세요."
              value={majorName}
              onChange={handleMajorName}
              required></input>
            <div className="errorMessageWrap">
              {!majorNameValid && majorName.length > 0 && <span>올바른 학과를 입력해주세요.</span>}
            </div>
          </div>

          {/* 이메일 */}
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

          {/* 비밀번호  */}
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

        {/* 가입이 가능한지에 따라 텍스트 다르게  */}
        <div id="is-join-possible">
          {(!emailValid || !passwordValid || !memberNameValid || !majorNameValid || !studentIdValid) && (
            <div className="joinErrorMessageWrap">
              <span style={{ color: 'red' }}>모든 정보를 확인해주세요.</span>
            </div>
          )}
          {emailValid && passwordValid && memberNameValid && majorNameValid && studentIdValid && (
            <div className="joinSuccessMessageWrap">
              <span>가입이 가능합니다!</span>
            </div>
          )}
        </div>

        {/* 가입 완료 버튼  */}
        <button onClick={handleSignupBtn} className="join-finish">
          회원가입 하기
        </button>
      </div>

      <div id="ewha-pic2">
        <img src="https://pharmind.ewha.ac.kr/_res/ewha/pharmind/img/main/img-main-vi01.jpg" alt="ewha-pic" />
      </div>
    </body>
  );
}
