import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { GoArrowLeft } from 'react-icons/go';
import { signUp } from '../../apis/signup';
import './signup.css';

export default function Signup() {
  const navigate = useNavigate();
  const [name, setName] = useState('');
  const [studentId, setStudentId] = useState('');
  const [majorName, setMajorName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const [emailValid, setEmailValid] = useState(false);
  const [passwordValid, setPasswordValid] = useState(false);
  const [studentIdValid, setStudentIdValid] = useState(false);
  const [majorNameValid, setMajorNameValid] = useState(false);
  const [nameValid, setNameValid] = useState(false);

  const [notAllow, setNotAllow] = useState(true);

  // 이름
  const handleName = e => {
    setName(e.target.value);
    const regex = /^[가-힣a-zA-Z\s]+$/;
    setNameValid(regex.test(e.target.value));
  };

  // 학번
  const handleStudentId = e => {
    setStudentId(e.target.value);
    // 학번은 7자리 숫자로 이루어진 것으로 가정
    const regex = /^\d{7}$/;
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

  // 비밀번호
  const handlePassword = e => {
    setPassword(e.target.value);
    const regex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    setPasswordValid(regex.test(e.target.value));
  };

  useEffect(() => {
    if (emailValid && passwordValid && nameValid && studentIdValid && majorNameValid) {
      setNotAllow(false);
      return;
    }
    setNotAllow(true);
  }, [emailValid, passwordValid, nameValid, studentIdValid, majorNameValid]);

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
    await signUp(email, name, password, majorName, studentId);
  };

  return (
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
          <input type="text" placeholder="성함을 입력해주세요." value={name} onChange={handleName} required></input>
          <div className="errorMessageWrap">
            {!nameValid && name.length > 0 && <span>올바른 이름을 입력해주세요.</span>}
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
          <div className="errorMessageWrap">{!studentIdValid && <span>올바른 학번 7자리를 입력해주세요.</span>}</div>
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
            {!passwordValid && password.length > 0 && <span>영문, 숫자, 특수문자 포함 8자 이상 입력해주세요.</span>}
          </div>
        </div>
      </form>

      {/* 가입이 가능한지에 따라 텍스트 다르게  */}
      <div id="is-join-possible">
        {(!emailValid || !passwordValid || !nameValid || !majorNameValid || !studentIdValid) && (
          <div className="joinErrorMessageWrap">
            <span style={{ color: 'red' }}>모든 정보를 확인해주세요.</span>
          </div>
        )}
        {emailValid && passwordValid && nameValid && majorNameValid && studentIdValid && (
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
  );
}
