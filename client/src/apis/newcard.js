import axios from 'axios';

export const newcard = async (title, content, majorId) => {
  try {
    const result = await axios.post(`http://15.165.199.6:8080/articles/${majorId}`, {
      title,
      content,
    });
    return result.data;
  } catch (error) {
    throw new Error(`Failed to create new card: ${error.message}`);
  }
};
