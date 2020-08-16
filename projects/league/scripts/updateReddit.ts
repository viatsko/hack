import * as fs from "fs";
import { CHAMPIONS_INDEX_FILE, CHAMPIONS_DIR } from "../dirs";
import axios from "axios";

const champions = require(CHAMPIONS_INDEX_FILE);

(async function () {
  for (const id of Object.keys(champions)) {
    // if (fs.existsSync(`${CHAMPIONS_DIR}/${id}/_reddit.json`)) {
    //   continue;
    // }

    const url = `https://www.reddit.com/r/${champions[id].redditUrl}/.json?count=20`;
    try {
      const response = await axios({
        url,
        method: "GET",
        responseType: "blob", // important
      });
      fs.writeFileSync(
        `${CHAMPIONS_DIR}/${id}/_reddit.json`,
        JSON.stringify(response.data, null, 2)
      );
    } catch (e) {
      console.log(id + " failed");
      console.log(url);
      process.exit(1);
    }
  }
})();
