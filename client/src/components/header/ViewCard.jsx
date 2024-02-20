// 카드 클릭 시 보여주기

import { useState } from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import NewCardModal from '../modal/Modal';
import EwhaLogo from './Logo';
import { Card } from '../list/Card';
import * as S from '../list/list.style';
import { MOCK_CARD_LIST } from '../list/card.const';

export const ViewCard = () => {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [selectedCard, setSelectedCard] = useState(null);

  const openModal = () => setIsModalOpen(true);
  const closeModal = () => setIsModalOpen(false);

  const handleCardClick = (id, title, member, content, createDate) => {
    setSelectedCard({ id, title, member, content, createDate });
    openModal();
  };

  return (
    <>
      <S.List>
        {MOCK_CARD_LIST.map(card => (
          <Card
            key={card.id}
            id={card.id}
            title={card.title}
            member={card.member}
            content={card.content}
            createDate={card.createDate}
            onClick={handleCardClick}
          />
        ))}
      </S.List>

      <div>
        <NewCardModal isOpen={isModalOpen} closeModal={closeModal}>
          <Box>
            {/* Use selectedCard data to display specific card content */}
            {selectedCard && (
              <>
                {/* Display selected card content in the modal */}
                <header>
                  <div className="ewha-logo">
                    <EwhaLogo />
                  </div>
                  <div className="new-card-info">
                    <div id="new-card-majorStudentId">
                      {selectedCard.member.major.majorName} {selectedCard.member.studentId}학번
                    </div>
                    <div id="view-card-createDate">{selectedCard.createDate}</div>
                  </div>
                </header>

                <fieldset id="card-title">
                  <input id="new-card-title" type="text" value={selectedCard.title} readOnly />
                </fieldset>

                <Box id="view-card-content-box">
                  <div id="view-card-content">{selectedCard.content}</div>
                </Box>

                <div className="comment-container">
                  <div className="new-card-info">댓글</div>
                  <div className="new-card-info">댓글</div>
                  <div className="new-card-info">댓글</div>
                </div>
              </>
            )}
          </Box>
        </NewCardModal>
      </div>
    </>
  );
};
