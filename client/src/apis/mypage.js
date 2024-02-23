import axios from 'axios';

export const fetchMyBookmark = async () => {
  try {
    const response = await axios.get('http://15.165.199.6:8080/user/bookmark');
    return response.data;
  } catch (error) {
    console.error('Failed to fetch bookmarked articles:', error);
    return [];
  }
};
