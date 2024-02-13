window.onscroll = function () {
  showScrollButton()
}

function showScrollButton() {
  const button = document.querySelector('.scroll-to-top')
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    button.style.display = 'block'
  } else {
    button.style.display = 'none'
  }
}

function scrollToTop() {
  // 맨 위로 스크롤
  document.body.scrollTop = 0
  document.documentElement.scrollTop = 0
}

const scrollToTopButton = document.querySelector('.scroll-to-top')
if (scrollToTopButton) {
  scrollToTopButton.addEventListener('click', scrollToTop)
}
