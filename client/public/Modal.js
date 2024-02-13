function showExpandedCardOnScreen(cardIndex) {
  // 카드를 확대해서 보이도록 스타일을 변경합니다.
  var cards = document.querySelectorAll('.card')
  cards.forEach(function (card, index) {
    card.classList.remove('expanded')
  })
  cards[cardIndex].classList.add('expanded')

  // 확대된 카드를 화면 상단으로 스크롤
  cards[cardIndex].scrollIntoView({behavior: 'smooth', block: 'start'})
}

// 카드 요소들을 선택
var cards = document.querySelectorAll('.card')

// 각각의 카드에 클릭 이벤트를 추가
cards.forEach(function (card, index) {
  card.addEventListener('click', function () {
    // showExpandedCardOnScreen 함수를 호출하여 카드를 현재 화면에서 확대해서 보여주기
    showExpandedCardOnScreen(index)
  })
})
