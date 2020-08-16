var global = require('./_global');
var spamMessages = require('./_spamMessages');
var auth = require('./_auth');

module.exports = {
  username: auth.slaves[2].username,
  oauth: auth.slaves[2].oauth,
  channel: global.controlChannel,
  mastername: global.mastername,
  spamInterval: global.spamInterval,
  spamMessages: spamMessages
};
