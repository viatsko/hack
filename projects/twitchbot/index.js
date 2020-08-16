var _ = require('lodash');

var exec = require('child_process').exec;
var fs = require('fs');
var glob = require('glob');

var opts = {
  runSlaves: false,
  onlyOneSlave: false,
  runMaster: false
};

if(process.argv.length === 2) {
  console.log("");
  console.log("No arguments given, valid arguments are:");
  console.log("");
  console.log("\t--run-slaves\tRun only slave bots.");
  console.log("\t--run-one-slave\tRun only first slave bot.");
  console.log("\t--run-master\tRun only master bot.");
}

process.argv.forEach(function (val, index, array) {
  if ('--run-slaves' === val) {
    opts.runSlaves = true;
  } else if ('--only-one-slave' === val) {
    opts.onlyOneSlave = true;
  } else if ('--run-master' === val) {
    opts.runMaster = true;
  }
});

var configs = glob.sync('./configs/**/*.js');

if (opts.runSlaves) {
  var processedConfigs = 0;
  _.each(configs, function (config) {
    var child;

    config = config.replace(/^\.\//, '');

    // respecting --only-one-slave option
    if (opts.onlyOneSlave &&
      processedConfigs > 0
    ) {
      return true;
    }

    // ignoring master.js in this loop
    if (config.match(/master\.js$/)) {
      return true;
    }

    // ignoring configs with underscore prefix,
    // those are includes
    if (config.match(/^_/) || config.match(/\/_/)) {
      return true;
    }

    processedConfigs++;

    console.log('executing child bot with command "' + 'node slave-bot ' + config + '"');

    /*
     * форкаем ботов-"подчиненных"
     */
    child = exec('node slave-bot ' + config,
      function (error, stdout, stderr) {
        console.log('stdout: ' + stdout);
        console.log('stderr: ' + stderr);
        if (error !== null) {
          console.log('exec error: ' + error);
        }
      });
  });
}

if (opts.runMaster) {
  _.each(configs, function (config) {
    var child;

    if (!config.match(/master\.js$/)) {
      return true;
    }

    console.log('executing master bot with command "' + 'node master-bot ' + config + '"');

    /*
     * форкаем ботов-"подчиненных"
     */
    child = exec('node master-bot ' + config,
      function (error, stdout, stderr) {
        console.log('stdout: ' + stdout);
        console.log('stderr: ' + stderr);
        if (error !== null) {
          console.log('exec error: ' + error);
        }
      });
  });
}
