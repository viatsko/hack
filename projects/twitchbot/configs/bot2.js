var global = require('./_global');
var spamMessages = require('./_spamMessages');
var auth = require('./_auth');

module.exports = {
  username: auth.slaves[1].username,
  oauth: auth.slaves[1].oauth,
  channel: global.controlChannel,
  mastername: global.mastername,
  spamInterval: global.spamInterval,
  spamMessages: spamMessages
};
