import { StrictMode } from 'react';
import ReactDOM from 'react-dom/client';
import App from './App.jsx';
// import Login from './components/login/Login.jsx';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <StrictMode>
    <App />\{/* <Login />\ */}
  </StrictMode>,
);
