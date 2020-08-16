import * as fs from "fs";
import { ProfileSchema, FeedItem, YouTubeVideo } from "../@types";
import { youtubeSchemaVideoToYouTubeVideo } from "../dataMappers/youtubeSchemaVideoToYouTubeVideo";
import { FEED_ITEMS_PER_PAGE } from "../config/constants";

const PROFILES_DIR = `${__dirname}/../profiles`;

const FEED_MAIN_FILE = `${__dirname}/../feed-main.generated.json`;

const FEED_MAIN_ABOVE_THE_FOLD_FILE = `${__dirname}/../feed-main-above-the-fold.generated.json`;

(async function (): Promise<void> {
  const profiles = fs.readdirSync(PROFILES_DIR);

  const allItems: FeedItem[] = [];

  for (const profile of profiles) {
    const profileJsonData: ProfileSchema = JSON.parse(
      fs.readFileSync(`${PROFILES_DIR}/${profile}/profile.json`, {
        encoding: "utf8",
        flag: "r",
      })
    );

    if (
      !fs.existsSync(`${__dirname}/../profiles/${profile}/youtube-videos.json`)
    ) {
      continue;
    }

    // eslint-disable-next-line @typescript-eslint/no-var-requires
    const origVideos = require(`../profiles/${profile}/youtube-videos.json`);

    const videos: YouTubeVideo[] = origVideos.map(
      youtubeSchemaVideoToYouTubeVideo
    );

    fs.writeFileSync(
      `${__dirname}/../profiles/${profile}/youtube-videos-above-the-fold.generated.json`,
      JSON.stringify(origVideos.slice(0, FEED_ITEMS_PER_PAGE), null, 2)
    );

    if (
      profileJsonData.tags &&
      profileJsonData.tags.indexOf("non-tech") !== -1
    ) {
      continue;
    }

    allItems.push(
      ...videos.map((video) => {
        return {
          profile: {
            slug: profile,
            displayName: profileJsonData.displayName,
            avatar: profileJsonData.thumbnails.medium?.url || "",
          },
          video,
        };
      })
    );
  }

  allItems.sort((a, b) => {
    const firstPublishedAt = new Date((a.video && a.video.publishedAt) || "");
    const secondPublishedAt = new Date((b.video && b.video.publishedAt) || "");

    return +secondPublishedAt - +firstPublishedAt;
  });

  fs.writeFileSync(FEED_MAIN_FILE, JSON.stringify(allItems, null, 2));
  fs.writeFileSync(
    FEED_MAIN_ABOVE_THE_FOLD_FILE,
    JSON.stringify(allItems.slice(0, FEED_ITEMS_PER_PAGE), null, 2)
  );
})();
