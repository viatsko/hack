import express from 'express';

import adminController from './admin';

const router = express.Router();

router.use('/admin', adminController);

router.get('/', (req, res) => {
  res.send('Welcome!');
});

export default router;
