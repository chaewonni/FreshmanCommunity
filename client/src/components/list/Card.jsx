import * as S from './list.style';

export const Card = ({ title, member }) => {
  const {
    major: { majorName },
  } = member;

  return (
    <S.Card>
      <S.Title>{title}</S.Title>
      <S.CardBottom>
        <S.Author>{majorName}</S.Author>
        <S.LikedNumber>
          <span className="material-symbols-outlined"> favorite </span>
          <div id="liked-number-count">10</div>
        </S.LikedNumber>
      </S.CardBottom>
    </S.Card>
  );
};
