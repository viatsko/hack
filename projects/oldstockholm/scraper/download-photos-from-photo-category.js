const scrapeIt = require('scrape-it');
const mongo = require('../mongo');

async function worker() {
  for (let index = 0; index < 25000; index += 10000) {
    console.log(`Parsing starting from index ${index}`);

    const response = await scrapeIt(
      `https://stockholmskallan.stockholm.se/sok/?cstids=12&size=10000&skip=${index}&ch=1`,
      {
        photos: {
          listItem: '.post-item',
          data: {
            title: '.post-caption',
            dateString: '.era:nth-child(2)',
            url: {
              selector: 'a',
              attr: 'href',
            },
            image: {
              selector: 'img',
              attr: 'src',
            },
          },
        },
      }
    );

    for (const fields of response.data.photos) {
      const Photo = mongo.models.Photo;

      fields.image = fields.image.split('?')[0];
      fields.postId = parseInt(fields.url.split('/')[2], 10);

      const photo = new Photo(fields);

      await photo.save();
    }
  }

  await mongo.mongoose.connection.close();
  process.exit(0);
}

worker();
