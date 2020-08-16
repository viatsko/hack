import * as fs from "fs";
import {
  FEED_MAIN_FILE,
  CHAMPIONS_INDEX_FILE,
  CHAMPIONS_REMAP_FILE,
  CHAMPIONS_DIR,
} from "../dirs";
import { FEED_ITEMS_PER_PAGE } from "../config/constants";

const allVideos = require(FEED_MAIN_FILE);

const champions = require(CHAMPIONS_INDEX_FILE);

const championsResult: { [key: string]: any } = {};

for (const id of Object.keys(champions)) {
  championsResult[id] = champions[id];
  championsResult[id].videos = [];
}

const championsRemap = require(CHAMPIONS_REMAP_FILE);

for (const video of allVideos) {
  let lcTitle = video.video.title.toLowerCase();
  const lcDescription = video.video.description.toLowerCase();

  if (lcTitle.indexOf(" vs ") !== -1) {
    lcTitle = lcTitle.split(" vs ")[0];

    for (const key in championsRemap) {
      if (lcTitle.indexOf(key) !== -1) {
        championsResult[championsRemap[key]].videos.length <=
          FEED_ITEMS_PER_PAGE &&
          championsResult[championsRemap[key]].videos.push(video);
      }
    }
  } else {
    for (const key in championsRemap) {
      if (lcTitle.indexOf(key) !== -1 || lcDescription.indexOf(key) !== -1) {
        championsResult[championsRemap[key]].videos.length <=
          FEED_ITEMS_PER_PAGE &&
          championsResult[championsRemap[key]].videos.push(video);
      }
    }
  }
}

for (const id of Object.keys(champions)) {
  if (!fs.existsSync(`${CHAMPIONS_DIR}/${id}`)) {
    fs.mkdirSync(`${CHAMPIONS_DIR}/${id}`);
  }
  fs.writeFileSync(
    `${CHAMPIONS_DIR}/${id}/_base.json`,
    JSON.stringify(championsResult[id], null, 2)
  );
  fs.writeFileSync(
    `${CHAMPIONS_DIR}/${id}/index.tsx`,
    `import champion from "./_base.json";

export default champion;
`
  );
}
