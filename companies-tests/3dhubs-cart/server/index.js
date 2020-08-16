const express = require('express');
const bodyParser = require('body-parser');
const path = require('path');
const fs = require('fs');

const uploadsDirectory = path.join(__dirname, '..', 'public', 'uploads');

const app = express();

let savedState = {
  cart: {
    items: [],
  },
};

app.use(bodyParser.urlencoded({
  extended: true,
  limit: '100mb',
}));

app.use(bodyParser.json({
  limit: '100mb',
}));

function errorResponse(res, error) {
  //res.status(401);
  console.log(error);
  res.json({
    error: error,
  });
}

function writeBase64ToUploads(data, uuid) {
  data = data.replace(/^.*?base64,/, '');

  const savePath = path.join(uploadsDirectory, uuid + '.stl');

  if (!fs.existsSync(savePath)) {
    fs.writeFileSync(
      savePath,
      data,
      {encoding: 'base64'}
    );
  }
}

app.post('/api/save_cart', function (req, res) {
  try {
    const state = req.body;

    if (state && state.cart && state.cart.items) {
      let items = [];

      for (let i = 0, ii = state.cart.items.length; i < ii; i++) {
        if (!state.cart.items[i].uuid) {
          errorResponse(res, 'Missing uuid');
          break;
        } else {
          if (state.cart.items[i].data) {
            writeBase64ToUploads(state.cart.items[i].data, state.cart.items[i].uuid);
            delete state.cart.items[i].data;
          }
          state.cart.items[i].url = '/uploads/' + state.cart.items[i].uuid + '.stl';
          items.push(state.cart.items[i]);
        }
      }

      savedState = state;

      res.json({
        items: items,
      });
    } else {
      errorResponse(res, 'Missing cart in state.');
    }
  } catch (e) {
    errorResponse(res, e.toString());
  }
});

app.get('/api/restore', function(req, res) {
  res.json(savedState);
});

app.listen(3001, function () {
  console.log('Backend is listening on port 3001!');
});
