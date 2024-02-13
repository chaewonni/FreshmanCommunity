import styled from 'styled-components';

export const List = styled.div`
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 40px;
  margin-top: 50px;
`;

export const Card = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  padding: 0 20px;
  background-color: #bddebd;
  box-shadow: 0 5px 15px gray;
  word-break: auto-phrase;
`;

export const CardBottom = styled.div`
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
`;

export const Title = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 30px 0;
  font-size: 28px;
  font-weight: bold;
  text-align: center;
  overflow-wrap: break-word;
  overflow: hidden;
  text-overflow: ellipsis;
  min-height: 300px;
`;

export const Author = styled.h2`
  background-color: #87a68779;
  padding: 2px 10px;
  border-radius: 40px;
  font-size: 14px;
`;
