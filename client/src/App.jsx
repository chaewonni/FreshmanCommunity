import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import './App.css';
// import Box from '@mui/material/Box';
// import Button from '@mui/material/Button';
// import Typography from '@mui/material/Typography';
// import { useState } from 'react';
// import NewCardModal from './components/modal/Modal';

import { Main, Mypage } from './components';

function App() {
  return (
    <div>
      <Router>
        <Routes>
          <Route path="/" element={<Main />} />
          <Route path="/mypage" element={<Mypage />} /> 
        </Routes>
      </Router>
    </div>
  );
}

export default App;
