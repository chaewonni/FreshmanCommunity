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
  box-shadow: 0 5px 15px gray;
  word-break: auto-phrase;
  &:nth-child(3n + 1) {
    background-color: #eef0e5;
  }
  &:nth-child(3n + 2) {
    background-color: #bddebd;
  }
  &:nth-child(3n + 3) {
    background-color: #40b375;
  }
`;

export const CardBottom = styled.div`
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 6px;
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
  background-color: #ffffff;
  padding: 5px 10px;
  border-radius: 40px;
  font-size: 14px;
`;

export const LikedNumber = styled.div`
  display: flex;
  font-weight: bold;
`;
