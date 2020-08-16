import * as React from "react";
import { FeedItem } from "../@types";
import { Card } from "./Card";
import { YoutubeEmbed } from "./YoutubeEmbed";

interface Props {
  feedItems: FeedItem[];
}

export function Feed(props: Props): JSX.Element {
  return (
    <>
      {props.feedItems.map((feedItem) => {
        if (feedItem.video) {
          const { video, profile } = feedItem;
          return (
            <Card
              title={video.title}
              description={video.description}
              personaLink={`/u/${profile?.slug}`}
              personaPhotoPath={profile?.avatar || ""}
              personaDisplayName={profile?.displayName || ""}
              tidbitText={`published a YouTube video`}
              timestamp={new Date(video.publishedAt || "")}
              key={video.videoId}
            >
              <YoutubeEmbed videoId={video.videoId || ""} />
            </Card>
          );
        } else {
          return null;
        }
      })}
    </>
  );
}
