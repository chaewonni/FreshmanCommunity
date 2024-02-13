import { Link } from 'react-router-dom';

export const Header = () => (
  <header>
    <div id="header-top">
      <Link to="#">Liked</Link>
      <Link to="#">Home</Link>
      <Link to="#">Logout</Link>
    </div>
    <div id="header-mid">
      {/* ewha where change begins 무엇이든 물어벗살  */}
      <div id="header-mid-left">
        <div id="ewha">
          <p>
            EWHA | <span>Where Change Begins</span>
          </p>
        </div>
        <div id="logo">
          <h1>
            <span>무</span>엇이든 <span>물</span>어<span>벗</span>살
          </h1>
        </div>
      </div>
      {/* 이화 로고 */}
      <img src="\assets\이화여대 로고.png" alt="ewha-logo" />
    </div>
    <nav className="dropdown">
      {/* TODO: 옵션 */}
      <div className="nav-dropdown">
        <button className="nav-dropdown-button">
          <span className="dropdown-display">과를 골라주세요.</span>
        </button>
        <div className="nav-dropdown-content">
          <button>컴퓨터공학과</button>
          <button>사이버보안학과</button>
          <button>..</button>
          <button>..</button>
        </div>
      </div>
    </nav>
  </header>
);
