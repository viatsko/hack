import { youtube_v3 } from "googleapis";
import { YouTubeVideo } from "../@types";

export const youtubeSchemaVideoToYouTubeVideo = (
  video: youtube_v3.Schema$Video
): YouTubeVideo => {
  return {
    publishedAt: video?.snippet?.publishedAt || "",
    title: video?.snippet?.title || "",
    description: video?.snippet?.description || "",
    // eslint-disable-next-line @typescript-eslint/no-explicit-any
    videoId: (video as any)?.snippet?.resourceId?.videoId || "",
    preview: video?.snippet?.thumbnails?.medium?.url || "",
  };
};
