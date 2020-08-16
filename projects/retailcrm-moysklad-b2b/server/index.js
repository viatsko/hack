import express from 'express';

import { PRODUCT_NAME } from "./constants";
import controllers from './controllers';
import db from './lib/db';
import logger from './lib/logger';

const port = process.env.PORT || 3000;

logger.info('Starting...');

const app = express();

app.set('view engine', 'ejs');
app.set('views', `${__dirname}/views`);

app.use(controllers);

const server = app.listen(port, () => {
  logger.info(`${PRODUCT_NAME} listening on port ${port}!`);

  server.close(() => {
    db.close();
  });
});
