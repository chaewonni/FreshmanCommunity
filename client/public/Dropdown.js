export function setNavDropdown() {
  // nav-dropdown class를 가진 element들을 모두 가져온다.
  const nodes = document.getElementsByClassName('nav-dropdown')

  // 드롭다운 메뉴 토글 함수
  function setToggle() {
    for (const node of nodes) {
      //   nav-dropdown내부의 버튼 요소들만 전부 가져온다
      const btns = node.getElementsByClassName('nav-dropdown-button')

      //   버튼요소를 클릭했을 때 state 상태에 따라 "dropdown-open" 클래스 제어 (이걸로 드롭다운 메뉴 표시 여부 판단하므로)
      const toggle = function (state = null) {
        const dropdownContents = node.getElementsByClassName('nav-dropdown-content')

        for (const content of dropdownContents) {
          if (state === null) {
            content.classList.toggle('dropdown-open')
          } else if (state === true) {
            content.classList.add('dropdown-open')
          } else if (state === false) {
            content.classList.remove('dropdown-open')
          }
        }
      }

      for (const btn of btns) {
        btn.addEventListener('click', () => toggle())
      }

      //   각각의 드롭다운 노드(node)에 toggleDropdown이라는 새로운 속성을 동적으로 추가
      //    다른 스크립트나 이벤트 핸들러에서 해당 노드의 드롭다운 상태를 쉽게 제어 가능
      node.toggleDropdown = toggle
    }
  }

  // 드롭다운에서 항목 선택하는 함수
  function setSelect() {
    for (const node of nodes) {
      const containers = node.getElementsByClassName('nav-dropdown-content')

      for (const container of containers) {
        // idx를 받으면 해당 idx에 해당하는 항목을 선택하는 함수
        function select(idx) {
          // 1. 선택된 항목에 dropdown-selected 클래스 추가, 그 외엔 제거
          const child = container.children[idx]
          for (const child of container.children) {
            child.classList.remove('dropdown-selected')
          }
          child.classList.add('dropdown-selected')

          //   dropdown-display 클래스를 가진 요소들의 텍스트를 선택된 항목의 텍스트로 변경
          const displays = node.getElementsByClassName('dropdown-display')
          for (const display of displays) {
            display.textContent = child.textContent
          }
        }

        let cnt = 0
        for (const child of container.children) {
          const thisIdx = cnt
          child.addEventListener('click', () => {
            // 기존에 동적으로 추가한 toggleDropdown을 false로 바꿈으로써 토글 닫음
            node.toggleDropdown(false)

            // 클릭한 인덱스를 select함수에 넘김
            select(thisIdx)
          })
          cnt++
        }

        select(0)
      }
    }
  }

  setToggle()
  setSelect()
}
