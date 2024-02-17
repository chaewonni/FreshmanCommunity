import { Link } from 'react-router-dom';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import { useState } from 'react';
// import Typography from '@mui/material/Typography';

// import NewCardModal from './components/modal/Modal';
import NewCardModal from '../modal/Modal';
import EwhaLogo from './Logo';

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
      <div className="ewha-logo">
        <EwhaLogo />
      </div>
    </div>

    <div className="choose-major">
      <label htmlFor="dino-select">과를 골라주세요 : </label>
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

export const NewCard = () => {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const openModal = () => setIsModalOpen(true);
  const closeModal = () => setIsModalOpen(false);

  return (
    <>
      <div>
        <Button onClick={openModal} id="new-card-button">
          <h2>+ NEW</h2>
        </Button>
      </div>

      <div>
        <NewCardModal isOpen={isModalOpen} closeModal={closeModal}>
          <Box>
            {/* 이화여대 로고, 글 작성자 과,학번, 글 작성 날짜   */}
            <header>
              <div className="ewha-logo">
                <EwhaLogo />
              </div>

              {/* 글 작성자 과,학번, 글 작성 날짜  */}
              <div className="new-card-info">
                <div id="new-card-majorStudentId">컴퓨터공학과 24학번</div>
                <div id="new-card-createDate">2024.01.26</div>
              </div>
            </header>

            {/* 제목, 글 본문  */}
            <fieldset>
              <input id="new-card-title" type="text" placeholder="[ 제목 ]" maxLength={24} />

              <textarea id="new-card-text" placeholder="내용을 입력해주세요." maxLength={719} />
            </fieldset>

            <Button type="submit">올리기</Button>
          </Box>
        </NewCardModal>
      </div>
    </>
  );
};

export default NewCard;
