import express from 'express';

const router = express.Router();

router.get('/', (req, res) => {
  res.render('admin-list', {
    action: 'admin/list'
  });
});

router.get('/new', (req, res) => {
  res.render('admin-new', {
    action: 'admin/new'
  });
});

export default router;
