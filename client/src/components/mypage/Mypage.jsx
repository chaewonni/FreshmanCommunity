import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Header } from '../header';
import { List } from '../list';
import { ViewCard } from '../header/ViewCard';

async function fetchMyBookmark() {
  try {
    const response = await axios.get('http://15.165.199.6:8080/user/bookmark');
    return response.data;
  } catch (error) {
    console.error('Failed to fetch bookmarked articles:', error);
    return [];
  }
}

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
      <List articles={myBookmark} onSelectArticle={handleSelectArticle}/>
      {isModalOpen && selectedArticle && (
        <ViewCard article={selectedArticle} onClose={handleCloseModal} />
      )}
    </>
  );
};
