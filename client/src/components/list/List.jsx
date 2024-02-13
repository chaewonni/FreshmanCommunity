import { Card } from './Card';
import { MOCK_CARD_LIST } from './card.const';
import * as S from './list.style';

export const List = () => (
  <S.List>
    {MOCK_CARD_LIST.map(card => (
      <Card key={card.id} {...card} />
    ))}
  </S.List>
);
