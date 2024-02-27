// /pages/api/index.js

const getAuth = token =>
  axios.create({
    baseURL: BASE_URL,
    headers: {
      'Content-Type': 'application/json;charset=UTF-8',
      Accept: 'application/json',
      Authorization: 'Bearer ' + token,

      // 추가
      'Access-Control-Allow-Origin': 'http://localhost:3000',
      'Access-Control-Allow-Credentials': 'true',
    },
  });
