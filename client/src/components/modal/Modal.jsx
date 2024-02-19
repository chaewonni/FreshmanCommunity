import * as React from 'react';
import Modal from '@mui/material/Modal';
import Paper from '@mui/material/Paper';

function NewCardModal({ isOpen, closeModal, children }) {
  return (
    <Modal open={isOpen} onClose={closeModal}>
      <Paper
        elevation={2}
        sx={{
          position: 'absolute',
          top: '50%',
          left: '50%',
          transform: 'translate(-50%, -50%)',
          width: 900,
          height: 900,
          maxWidth: '100%',
          maxHeight: '90%',
          overflowY: 'auto',
        }}>
        {children}
      </Paper>
    </Modal>
  );
}

export default NewCardModal;
