twitchbot
===

### Параметры запуска:

* `--run-slaves` - запустить подчиненных ботов

* `--only-one-slave` - запускать только одного подчиненного бота

* `--run-master` - запустить бота-мастера (для управляющей машины, все остальные боты должны будут знать его имя, см.
`mastername` в конфиге)

* `--top20` - просмотреть top20 twitch'а

### Конфиг master-бота

Всегда должен называться `master.js`.

### Конфиги slave-ботов

Тут все просто делается по примеру:

```js
module.exports = {
  username: 'Kelopalapa',
  oauth: 'oauth:r3ocgguu2qqol7dquu3nf6nq62m9n1',
  channel: '#dwrsc2',
  mastername: 'dwrsc2',
  spamMessages: [
    'http://koroboost.com - best place to buy a gaming service',
    'koroboost.com - best place to get a boost',
    'koroboost com - become gladiator right now',
    'koroboost,com - your service of choice'
  ]
};
```
