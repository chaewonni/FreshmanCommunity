import React from "react";
import "./style/login.css";

const Login = () => {
  return (
    <>
      <div id="login_container">
        <div id="login_top">
          <h1>로그인</h1>
          <h3>
            <span>이화</span> | Where Change Begins
          </h3>
        </div>

        <form action="#" method="post" name="login_middle">
          <fieldset>
            <ul>
              {/* 이메일 */}
              <label htmlFor="email" id="email_label">
                Email*
              </label>
              <li>
                <input
                  type="email"
                  name="email"
                  placeholder="이메일을 입력해주세요."
                  id="email_input"
                />
              </li>

              {/* 패스워드 */}
              <label htmlFor="password" id="psw_label">
                Password*
              </label>
              <li>
                <input
                  type="password"
                  name="password"
                  placeholder="비밀번호를 입력해주세요."
                  id="psw_input"
                />
              </li>
            </ul>
          </fieldset>
        </form>

        <div id="login_bottom">
          <button id="login_btn">로그인하기</button>
          <p>
            아직 계정이 없으신가요?
            <a href="createAccount.html">회원가입 하기</a>
          </p>
        </div>
      </div>
      <div id="ewha_img">
        <div id="rectangle_login"></div>
        <img src="image/이화여대 캠퍼스 가을.jpg" alt="이화여대 캠퍼스" />
        <p>
          "세상은 <span>이화</span>에게 물었고, <span>이화</span>는 그대를
          답했다."
        </p>
      </div>
    </>
  );
};

export default Login;
