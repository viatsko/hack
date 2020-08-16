const fs = require('fs');

exports.ensureExists = function ensureExists(path, mask) {
  return new Promise((resolve, reject) => {
    fs.mkdir(path, function(err) {
        if (err) {
            if (err.code === 'EEXIST') {
              resolve();
            } else {
              reject(err);
            }
        } else {
          resolve(null);
        }
    });
  });
}

exports.getUserHome = function getUserHome() {
  return process.env[(process.platform == 'win32') ? 'USERPROFILE' : 'HOME'];
}
