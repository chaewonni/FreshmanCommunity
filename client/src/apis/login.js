import axios from 'axios';

export const login = async (email, password) => {
  const result = await axios.post('http://15.165.199.6:8080/users/login', { email, password });
  return result.data;
};
