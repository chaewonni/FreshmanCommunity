import { useState } from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import NewCardModal from '../modal/Modal';
import EwhaLogo from './Logo';

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
