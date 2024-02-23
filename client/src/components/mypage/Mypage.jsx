// mypage.js
import React, { useEffect, useState } from 'react';
import { Header } from '../header';
import { ViewCard } from '../header/ViewCard';
import { fetchMyBookmark } from '../../apis/mypage';

export const Mypage = () => {
  const [myBookmark, setMyBookmark] = useState([]);
  const [selectedArticle, setSelectedArticle] = useState(null);
  const [isModalOpen, setIsModalOpen] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const data = await fetchMyBookmark();
        setMyBookmark(data.bookmarks);
      } catch (error) {
        console.error('Failed to fetch bookmarked articles:', error);
        setMyBookmark([]);
      }
    };

    fetchData();
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
      <ViewCard articles={myBookmark} onSelectArticle={handleSelectArticle} />
      {isModalOpen && selectedArticle && <ViewCard article={selectedArticle} onClose={handleCloseModal} />}
    </>
  );
};
