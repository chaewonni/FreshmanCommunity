import axios from 'axios';

export const signUp = async (memberName, studentId, email, password, majorName) => {
  const result = await axios.post('http://15.165.199.6:8080/user/signup', {
    memberName,
    studentId,
    email,
    password,
    majorName,
  });
  return result.data;
};
