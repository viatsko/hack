import { google, youtube_v3 } from "googleapis";

const ROOT_DIR = `${__dirname}/..`;

const youtube = google.youtube({
  version: "v3",
  auth: require(`${ROOT_DIR}/secrets.json`).YOUTUBE_API_KEY,
});

export async function getYoutubeChannelsData(
  ids: string[]
): Promise<youtube_v3.Schema$Channel[] | undefined> {
  const response = await youtube.channels.list({
    id: ids.join(","),
    part: "snippet,contentDetails",
  });

  const {
    data: { items },
  } = response;

  return items;
}

export async function getYoutubePlaylistItemsData(
  playlistId: string,
  maxPages = 9999
): Promise<youtube_v3.Schema$PlaylistItem[]> {
  let currentPage = 1;

  const result: youtube_v3.Schema$PlaylistItem[] = [];

  let response;

  let pageToken;

  do {
    response = await youtube.playlistItems.list({
      playlistId,
      part: "snippet",
      maxResults: 50,
      pageToken,
    });

    pageToken = response.data.nextPageToken;

    const {
      data: { items },
    } = response;

    result.push(...(items || []));
  } while (pageToken && ++currentPage <= maxPages);

  return result;
}
