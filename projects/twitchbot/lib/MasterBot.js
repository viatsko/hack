import _ from 'lodash';

import fs from 'fs';
import path from 'path';
import irc from 'twitch-irc';

import auth from '../configs/_auth';
import global from '../configs/_global';

import settings from '../configs/master';

var clientOptions = {
  options: {
    debug: true,
    debugIgnore: [
      'ping',
      'chat',
      'action'
    ],
    database: '../data'
  },
  identity: {
    username: settings.username,
    password: settings.oauth
  },
  channels: [
    settings.channel
  ]
};

var silenceList = {};
var channelList = {};

var client = new irc.client(clientOptions);
var db = require('twitch-irc-db')({
  database: '../data'
});
var api = require('twitch-irc-api');

var ignoreList = require('../configs/_ignoreList.json');

client.connect();

setInterval(function() {
  top20();
}, global.topInterval);

client.addListener('chat', function (channel, user, message) {
  _.each(settings.slaves, function(slave, _botNo) {
    if(slave.username === user) {
      silenceList[_botNo] = new Date();
    }
  });

  _.each(silenceList, function(silenceEntry) {
    if(silenceEntry.getTime() - (new Date).getTime() > settings.silenceInterval) {
      client.say(settings.channel, '!top20');
    }
  });

  if (channel === settings.channel) {
    let messageParts;

    if (message.match(/^!ignore/)) {
      messageParts = message.split(' ');

      if(ignoreList.indexOf(messageParts[1]) === -1) {
        ignoreList.push(messageParts[1]);

        fs.writeFileSync(path.resolve('../configs/_ignoreList.json'), JSON.stringify(ignoreList));

        client.say(settings.channel, 'Added ' + messageParts[1] + ' to ignore list.');
        client.say(settings.channel, 'Now ignoring: ' + ignoreList.join(','));
      } else {
        client.say(settings.channel, messageParts[1] + " is already on ignore list.");
      }
    }

    if (message.match(/^!unignore/)) {
      messageParts = message.split(' ');

      let index = ignoreList.indexOf(messageParts[1]);
      if(index !== -1) {
        ignoreList.splice(index, 1);

        fs.writeFileSync(path.resolve('../configs/_ignoreList.json'), JSON.stringify(ignoreList));

        client.say(settings.channel, 'Removed ' + messageParts[1] + ' from ignore list.');
        client.say(settings.channel, 'Now ignoring: ' + ignoreList.join(','));
      } else {
        client.say(settings.channel, messageParts[1] + " not found in ignore list.");
      }
    }

    if (message.match(/^!top20/)) {
      top20();
    }
  }

  console.log(user.username + ': ' + channel + ': ' + message);
});

function top20() {
  api.call({
    channel: settings.channel,
    method: 'GET',
    path: '/streams',
    options: {
      game: 'World of Warcraft: Warlords of Draenor'
    }
  }, db, function (err, statusCode, response) {
    if (err) {
      client.say(settings.channel, "Error getting top20 from twitch.");
      return;
    }

    let channelNo = 1;
    let botNo = 1;
    let validBot = true;

    if (response.hasOwnProperty('streams')) {
      _.each(response.streams, function (stream) {
        let channelMessage = channelNo + '. ' + stream.channel.name + ' - ' + stream.viewers;

        if (ignoreList.indexOf(stream.channel.name) !== -1) {
          channelMessage += ' [on ignore list, skipping]';

          client.say(settings.channel, channelMessage);

          return true;
        }

        if (validBot) {
          channelMessage += ' [assigned to bot' + botNo + ']';
        }

        client.say(settings.channel, channelMessage);

        if (validBot) {
          client.say(settings.channel, '!assign bot' + botNo + ' ' + stream.channel.name);

          silenceList[botNo] = new Date();
          channelList[botNo] = '#' + stream.channel.name;

          // идем бейбиситить детей!!
          client.join('#' + stream.channel.name);

          botNo++;

          if(botNo > 10) {
            validBot = false;
          }
        }

        channelNo++;
      });
    }
  });
}
