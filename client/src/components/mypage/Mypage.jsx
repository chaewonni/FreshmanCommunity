import React, { useEffect, useState } from 'react';
import { Header } from '../header';
import { List } from '../list';
import { ViewCard } from '../header/ViewCard';
import { fetchMyBookmark } from '../../apis/mypage';

export const Mypage = () => {
  const [myBookmark, setMyBookmark] = useState([]);
  const [selectedArticle, setSelectedArticle] = useState(null);
  const [isModalOpen, setIsModalOpen] = useState(false);

  useEffect(() => {
    fetchMyBookmark().then(data => {
      setMyBookmark(data);
    });
  }, []);

  const handleSelectArticle = article => {
    setSelectedArticle(article);
    setIsModalOpen(true);
  };

  const handleCloseModal = () => {
    setIsModalOpen(false);
  };

  return (
    <>
      <Header showMajor={false} myBookmark={true} />
      <List articles={myBookmark} onSelectArticle={handleSelectArticle} />
      {isModalOpen && selectedArticle && <ViewCard article={selectedArticle} onClose={handleCloseModal} />}
    </>
  );
};
