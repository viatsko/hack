import * as fs from "fs";
import { ProfileSchema } from "../@types";
import {
  getYoutubeChannelsData,
  getYoutubePlaylistItemsData,
} from "../apis/youtube";

const ROOT_DIR = `${__dirname}/..`;

(async function (): Promise<void> {
  const profileName = "ted";
  const channelId = "UCAuUUnT6oDeKwE6v1NGQxug";

  if (!fs.existsSync(`${ROOT_DIR}/profiles/${profileName}`)) {
    fs.mkdirSync(`${ROOT_DIR}/profiles/${profileName}`);
  }

  const profileJsonFile = `${ROOT_DIR}/profiles/${profileName}/profile.json`;
  if (!fs.existsSync(profileJsonFile)) {
    fs.writeFileSync(profileJsonFile, JSON.stringify({}, null, 2));
  }

  const profileJson: ProfileSchema = JSON.parse(
    fs.readFileSync(profileJsonFile, { encoding: "utf8", flag: "r" })
  );

  if (!profileJson.youtubeChannel) {
    const channelsData = await getYoutubeChannelsData([channelId]);

    // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
    const channelData = channelsData![0];

    profileJson.youtubeChannel = {
      metadata: channelData as { id: string },
      uploadsPlaylist:
        channelData.contentDetails?.relatedPlaylists?.uploads || "",
    };

    profileJson.displayName = channelData.snippet?.title || "";

    profileJson.description = channelData.snippet?.description || "";

    profileJson.thumbnails = {
      default: {
        url: channelData.snippet?.thumbnails?.default?.url || "",
        width: channelData.snippet?.thumbnails?.default?.width || 0,
        height: channelData.snippet?.thumbnails?.default?.height || 0,
      },
    };

    profileJson.thumbnails.medium = {
      url: channelData.snippet?.thumbnails?.medium?.url || "",
      width: channelData.snippet?.thumbnails?.medium?.width || 0,
      height: channelData.snippet?.thumbnails?.medium?.height || 0,
    };

    profileJson.thumbnails.high = {
      url: channelData.snippet?.thumbnails?.high?.url || "",
      width: channelData.snippet?.thumbnails?.high?.width || 0,
      height: channelData.snippet?.thumbnails?.high?.height || 0,
    };
  }

  if (profileJson.youtubeChannel.uploadsPlaylist) {
    const profileYouTubeVideosJsonFile = `${ROOT_DIR}/profiles/${profileName}/youtube-videos.json`;
    fs.writeFileSync(
      profileYouTubeVideosJsonFile,
      JSON.stringify(
        await getYoutubePlaylistItemsData(
          profileJson.youtubeChannel.uploadsPlaylist
        ),
        null,
        2
      )
    );
  }

  fs.writeFileSync(profileJsonFile, JSON.stringify(profileJson, null, 2));
})();
