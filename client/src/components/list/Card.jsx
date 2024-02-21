import * as S from './list.style';

export const Card = ({ id, title, member, onClick, content, createDate }) => {
  const handleClick = () => {
    if (typeof onClick === 'function') {
      onClick(id, title, member, content, createDate);
    }
  };

  const {
    major: { majorName },
  } = member;

  return (
    <S.Card onClick={handleClick}>
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
