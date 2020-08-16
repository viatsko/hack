import * as React from "react";
import { FeedItem } from "../../@types";
import { YoutubeCard } from "../youtube-card/YoutubeCard";
//import { YoutubeEmbed } from "../youtube-embed/YoutubeEmbed";
import { makeStyles } from "@material-ui/core";
import classNames from "classnames";

interface Props {
  feedItems: FeedItem[];
  count?: 3 | 4;
}

const useStyles = makeStyles((_theme) => ({
  grid: {
    display: "grid",
    gridGap: "16px",
    gridTemplateColumns: "repeat(3, 1fr)",
  },
  grid4: {
    gridTemplateColumns: "repeat(4, 1fr)",
  },
}));

export function Feed(props: Props): JSX.Element {
  const styles = useStyles();

  return (
    <div className={classNames(styles.grid, props.count === 4 && styles.grid4)}>
      {props.feedItems.map((feedItem) => {
        if (feedItem.video) {
          const { video, profile } = feedItem;
          return (
            <YoutubeCard
              video={video}
              personaLink={`/u/${profile?.slug}`}
              personaPhotoPath={profile?.avatar || ""}
              personaDisplayName={profile?.displayName || ""}
              tidbitText={`published a YouTube video`}
              timestamp={new Date(video.publishedAt || "")}
              key={video.videoId}
            />
          );
        } else {
          return null;
        }
      })}
    </div>
  );
}
