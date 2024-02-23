import { useState } from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import NewCardModal from '../modal/Modal';
import EwhaLogo from '../header/Logo';
import { newcard } from '../../apis/newcard';

export const NewCard = () => {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');

  const openModal = () => setIsModalOpen(true);
  const closeModal = () => setIsModalOpen(false);

  const handleTitleChange = e => setTitle(e.target.value);
  const handleContentChange = e => setContent(e.target.value);

  const handleSubmit = async () => {
    try {
      const result = await newcard(title, content);
      console.log(result); // 서버 응답 확인
      // 필요한 경우, 서버 응답을 상태로 업데이트하거나 다른 작업을 수행할 수 있습니다.
      closeModal(); // 모달 닫기
    } catch (error) {
      console.error('Error creating new card:', error);
      // 에러 처리 로직 추가
    }
  };

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

            {/* 제목, 글 본문  */}
            <fieldset>
              <header>
                <div className="ewha-logo">
                  <EwhaLogo />
                </div>
                <input
                  id="new-card-title"
                  type="text"
                  placeholder="[ 제목 ]"
                  maxLength={24}
                  value={title}
                  onChange={handleTitleChange}
                />
              </header>

              <textarea
                id="new-card-text"
                placeholder="내용을 입력해주세요."
                maxLength={719}
                value={content}
                onChange={handleContentChange}
              />
            </fieldset>

            <Button type="submit" onClick={handleSubmit}>
              올리기
            </Button>
          </Box>
        </NewCardModal>
      </div>
    </>
  );
};
