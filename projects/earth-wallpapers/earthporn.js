const request = require('request');

const url = 'https://api.reddit.com/r/earthporn/hot';

exports.downloadImages = function downloadImages() {
  return new Promise((resolve, reject) => {
    request({
      url,
      headers: {
        'User-Agent': 'github.com/viatsko/earth-wallpapers:v1.0.0 (by /u/viatsko)'
      }
    }, (err, resp) => {
      const pictures = [];

      if (!err) {
        try {
          const data = JSON.parse(resp.body).data.children;

          const l = data.length;
          for (let i = 0; i < l; i++) {
            if (data[i].data && data[i].data.url && /\.jpg$/.test(data[i].data.url)) {
              pictures.push(data[i].data.url);
            }
          }
        } catch (e) {
          // Ignored
        }
      }

      resolve(pictures);
    });
  });
}
