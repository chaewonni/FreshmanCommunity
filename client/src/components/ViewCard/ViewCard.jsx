// 카드 클릭 시 보여주기

import React, { useState, useEffect } from 'react';
import Box from '@mui/material/Box';
import { RiAddBoxLine } from 'react-icons/ri';
import NewCardModal from '../modal/Modal';
import EwhaLogo from '../header/Logo';
import { Card } from '../list/Card';
import * as S from '../list/list.style';
import { MOCK_CARD_LIST } from '../list/card.const';
import { fetchMyViewCard } from '../../apis/viewcard';

export const ViewCard = () => {
  const [myViewCard, setMyViewCard] = useState([]);

  const [isModalOpen, setIsModalOpen] = useState(false);
  const [selectedCard, setSelectedCard] = useState(null);

  const openModal = () => setIsModalOpen(true);
  const closeModal = () => setIsModalOpen(false);

  const handleCardClick = (id, title, member, content, createDate) => {
    setSelectedCard({ id, title, member, content, createDate });
    openModal();
  };

  // 데이터
  useEffect(() => {
    const fetchData = async () => {
      try {
        const data = await fetchMyViewCard();
        setMyViewCard(data.bookmarks);
      } catch (error) {
        console.error('Failed to fetch this article:', error);
        setMyViewCard([]);
      }
    };

    fetchData();
  }, []);

  // 게시글 클릭 시 커서 변경

  document.body.style.cursor = 'pointer';

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
          <Box id="view-card-top">
            {selectedCard && (
              <>
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

                {/* 댓글  view */}
                <div className="comment-container">
                  <div className="comment">
                    <header>
                      <div className="ewha-logo">
                        <EwhaLogo />
                      </div>

                      {/* 댓글 작성자 학과,학번, 작성 날짜 */}
                      <div className="view-card-info">
                        <div id="view-card-majorStudentId">
                          {selectedCard.member.major.majorName} {selectedCard.member.studentId}학번
                        </div>

                        <div id="view-card-createDate">{selectedCard.createDate}</div>
                      </div>

                      <div id="comment-like-count">♡21</div>
                    </header>

                    {/* 댓글 내용  */}
                    <div className="comment-content">그렇게 말고 종합과학관을 통해서</div>
                  </div>

                  <div className="comment">
                    <header>
                      <div className="ewha-logo">
                        <EwhaLogo />
                      </div>

                      {/* 댓글 작성자 학과,학번, 작성 날짜 */}
                      <div className="view-card-info">
                        <div id="view-card-majorStudentId">
                          {selectedCard.member.major.majorName} {selectedCard.member.studentId}학번
                        </div>

                        <div id="view-card-createDate">{selectedCard.createDate}</div>
                      </div>

                      <div id="comment-like-count">♡21</div>
                    </header>

                    {/* 댓글 내용  */}
                    <div className="comment-content">그렇게 말고 종합과학관을 통해서</div>
                  </div>

                  <div className="comment">
                    <header>
                      <div className="ewha-logo">
                        <EwhaLogo />
                      </div>

                      {/* 댓글 작성자 학과,학번, 작성 날짜 */}
                      <div className="view-card-info">
                        <div id="view-card-majorStudentId">
                          {selectedCard.member.major.majorName} {selectedCard.member.studentId}학번
                        </div>

                        <div id="view-card-createDate">{selectedCard.createDate}</div>
                      </div>

                      <div id="comment-like-count">♡21</div>
                    </header>

                    {/* 댓글 내용  */}
                    <div className="comment-content">그렇게 말고 종합과학관을 통해서</div>
                  </div>

                  {/* 새 댓글 작성 칸  */}
                  <div className="new-comment-container">
                    <input id="new-comment" type="text" placeholder="댓글을 입력해주세요." maxLength={100} />

                    {/* 댓글 작성 완료  */}
                    <RiAddBoxLine
                      style={{ color: 'white', fontSize: '40px' }}
                      // onClick={} 댓글 작성 완료하고 + 버튼 누르면 댓글 내용 전송되는 부분, 추후 추가
                    />
                  </div>
                </div>
              </>
            )}
          </Box>
        </NewCardModal>
      </div>
    </>
  );
};
