import { Link } from 'react-router-dom';

export const Header = () => (
  <header>
    <div id="header-top">
      <Link to="#">Liked</Link>
      <Link to="#">Home</Link>
      <Link to="#">Logout</Link>
    </div>
    <div id="header-mid">
      {/* ewha where change begins 무엇이든 물어벗살  */}
      <div id="header-mid-left">
        <div id="ewha">
          <p>
            EWHA | <span>Where Change Begins</span>
          </p>
        </div>
        <div id="logo">
          <h1>
            <span>무</span>엇이든 <span>물</span>어<span>벗</span>살
          </h1>
        </div>
      </div>
      {/* 이화 로고 */}
      <img
        src="data:image/png;base64,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"
        alt="ewha-logo"
      />
    </div>

    <div className="choose-major">
      <label for="dino-select">과를 골라주세요 : </label>
      <select className="choose-major-option">
        <optgroup label="인문과학대학">
          <option>국어국문학과</option>
          <option>중어중문학과</option>
          <option>불어불문학과</option>
          <option>독어독문학과</option>
          <option>사학과</option>
          <option>철학과</option>
          <option>기독교학과</option>
          <option>영어영문학부</option>
        </optgroup>
        <optgroup label="사회과학대학">
          <option>정치외교학과</option>
          <option>행정학과</option>
          <option>경제학과</option>
          <option>문헌정보학과</option>
          <option>사회학과</option>
          <option>사회복지학과</option>
          <option>심리학과</option>
          <option>소비자학과</option>
          <option>커뮤니케이션-미디어학부</option>
        </optgroup>
        <optgroup label="자연과학대학">
          <option>수학과</option>
          <option>통계학과</option>
          <option>물리학과</option>
          <option>화학-나노과학전공</option>
          <option>생명과학전공</option>
        </optgroup>
        <optgroup label="공과대학">
          <option>전자전기공학전공</option>
          <option>식품생명공학과</option>
          <option>화공신소재공학과</option>
          <option>건축학과(5년)</option>
          <option>건축도시시스템공학과</option>
          <option>환경공학과</option>
          <option>기후·에너지시스템공학과</option>
          <option>휴먼기계바이오공학과</option>
          <option>지능형반도체공학전공</option>
        </optgroup>
        <optgroup label="인공지능대학">
          <option>사이버보안학과</option>
          <option>컴퓨터공학과</option>
          <option>인공지능학과</option>
          <option>데이터사이언스학과</option>
        </optgroup>
        <optgroup label="음악대학">
          <option>건번악기과</option>
          <option>관현악과</option>
          <option>성악과</option>
          <option>작곡과</option>
          <option>한국음악과</option>
          <option>무용과</option>
        </optgroup>
        <optgroup label="조형예술대학">
          <option>동양화전공</option>
          <option>조소전공</option>
          <option>서양화전공</option>
          <option>도자예술전공</option>
          <option>섬유예술전공</option>
          <option>패션디자인전공</option>
          <option>공간디자인전공</option>
          <option>시각디자인전공</option>
          <option>산업디자인전공</option>
          <option>영상디자인전공</option>
        </optgroup>
        <optgroup label="사범대학">
          <option>교육학과</option>
          <option>유아교육과</option>
          <option>초등교육과</option>
          <option>교육공학과</option>
          <option>특수교육과</option>
          <option>영어교육과</option>
          <option>역사교육전공</option>
          <option>사회교육전공</option>
          <option>국어교육과</option>
          <option>과학교육과</option>
          <option>수학교육과</option>
        </optgroup>
        <optgroup label="경영대학">
          <option>경영학부</option>
        </optgroup>
        <optgroup label="신산업융합대학">
          <option>의류산업학과</option>
          <option>국제사무학과</option>
          <option>융합콘텐츠학과</option>
          <option>식품영양학과</option>
          <option>융합보건학과</option>
          <option>체육과학부</option>
        </optgroup>
        <optgroup label="의과대학">
          <option>의예과</option>
        </optgroup>
        <optgroup label="간호대학">
          <option>간호학부</option>
        </optgroup>
        <optgroup label="약학대학">
          <option>약학전공</option>
          <option>미래산업약학전공</option>
        </optgroup>
        <optgroup label="스크랜튼대학">
          <option>자유전공학과</option>
          <option>국제학부</option>
          <option>뇌인지과학부</option>
        </optgroup>
        <optgroup label="호크마교양대학">
          <option>호크마교양학부</option>
        </optgroup>
      </select>
    </div>
  </header>
);
