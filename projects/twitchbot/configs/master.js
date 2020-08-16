var auth = require('./_auth');

/*
 * Настройки мастер-бота
 */
module.exports = {
  /*
   * Данные для авторизации
   */

  // имя пользователя
  username: auth.master.username,

  // oauth ключ
  oauth: auth.master.oauth,

  /*
   * Контрольный канал для бота
   */
  channel: '#dwrsc2'
};
