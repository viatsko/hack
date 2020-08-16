import * as fs from "fs";
import { ProfileSchema } from "../@types";
import { getYoutubePlaylistItemsData } from "../apis/youtube";
import { youtube_v3 } from "googleapis";

const PROFILES_DIR = `${__dirname}/../profiles`;

const ROOT_DIR = `${__dirname}/..`;

(async function (): Promise<void> {
  const profiles = fs.readdirSync(PROFILES_DIR);

  for (const profile of profiles) {
    const profileJson: ProfileSchema = JSON.parse(
      fs.readFileSync(`${PROFILES_DIR}/${profile}/profile.json`, {
        encoding: "utf8",
        flag: "r",
      })
    );

    const youtubeChannelId = profileJson?.youtubeChannel?.metadata?.id || null;

    if (youtubeChannelId) {
      const profileYouTubeVideosJsonFile = `${ROOT_DIR}/profiles/${profile}/youtube-videos.json`;

      const oldVideos: youtube_v3.Schema$Video[] = JSON.parse(
        fs.readFileSync(profileYouTubeVideosJsonFile, {
          encoding: "utf8",
          flag: "r",
        })
      );

      const existingVideoIds = new Set();
      for (const video of oldVideos) {
        existingVideoIds.add(video.id);
      }

      const headVideos = await getYoutubePlaylistItemsData(
        profileJson.youtubeChannel.uploadsPlaylist,
        1
      );

      const newVideos: youtube_v3.Schema$Video[] = [];

      for (const video of headVideos) {
        if (!existingVideoIds.has(video.id)) {
          newVideos.push(video as youtube_v3.Schema$Video);
        }
      }

      console.log(`${profile} new videos: ${newVideos.length}`);

      const mergedVideos = [...newVideos, ...oldVideos];

      fs.writeFileSync(
        profileYouTubeVideosJsonFile,
        JSON.stringify(mergedVideos, null, 2)
      );
    }
  }
})();
