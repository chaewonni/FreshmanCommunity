import axios from 'axios';

export const signUp = async (email, password, memberName, studentId, majorName) => {
  const result = await axios.post('http://15.165.199.6:8080/user/signup', {
    email,
    password,
    memberName,
    studentId,
    majorName,
  });
  return result.data;
};
