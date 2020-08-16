var _ = require('lodash');

var fs = require('fs');
var irc = require('twitch-irc');

var settings = {};

var seqName = '';

process.argv.forEach(function (val, index, array) {
  if (val.match(/\.js$/)) {
    if (fs.existsSync('./' + val)) {
      settings = require('./' + val);

      seqName = val;

      console.log('Using config file from: "./' + val + '".');
    } else {
      var errorMessage = 'Config file "./' + val + '" not found.';

      console.error(errorMessage);

      throw Error(errorMessage);
    }
  }
});

seqName = seqName.replace(/(.*)?\//, '');
seqName = seqName.replace(/\.js$/, '');

var clientOptions = {
  options: {
    debug: true,
    debugIgnore: [
      'ping',
      'chat',
      'action'
    ],
    database: './data'
  },
  identity: {
    username: settings.username,
    password: settings.oauth
  },
  channels: [
    settings.channel
  ]
};

var client = new irc.client(clientOptions);
var db = require('twitch-irc-db')({database: './data'});
var api = require('twitch-irc-api');

var channels = [settings.channel];

client.connect();

client.addListener('chat', function (channel, user, message) {
  if (channel === settings.channel) {
    if (message.match(/^!assign/)) {
      var messageParts = message.split(' ');

      if(channels.length > 1 && channels[1] !== messageParts[2]) {
        client.part(channels[1]);
      }

      if(messageParts[1] === seqName) {
        channels = [settings.channel];

        channels.push('#' + messageParts[2]);

        client.join('#' + messageParts[2]);

        client.say(settings.channel, 'Me assigned to ' + messageParts[2]);
      }
    }
  }
});

var i = 0;
setInterval(function () {
  _.each(channels, function(channel) {
    client.say(channel, settings.spamMessages[i]);
  });

  i++;
  if (i === settings.spamMessages.length) {
    i = 0;
  }
}, settings.spamInterval);
