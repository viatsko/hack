import { PRODUCT_NAME } from "../constants";

import chalk from 'chalk';

export default {
  info(message) {
    process.stdout.write(chalk.green(`[${PRODUCT_NAME}] ${message}`) + '\n');
  }
};
