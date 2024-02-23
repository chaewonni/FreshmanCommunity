// 게시글 하나 조회
import axios from 'axios';

export const fetchMyViewCard = async () => {
  try {
    const response = await axios.get('http://15.165.199.6:8080/article/{majorId}');
    return response.data;
  } catch (error) {
    console.error('Failed to fetch this article:', error);
    return [];
  }
};
