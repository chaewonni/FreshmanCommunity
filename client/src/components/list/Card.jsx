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
        <div className="liked-number">
          <span className="material-symbols-outlined"> favorite </span>
          <div id="liked-number-count">10</div>
        </div>
      </S.CardBottom>
    </S.Card>
  );
};
