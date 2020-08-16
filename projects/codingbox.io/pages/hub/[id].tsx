import React from "react";
import { GetStaticProps, GetStaticPaths } from "next";
import { YouTubeVideo, FeedItem, Hub } from "../../@types";
import { Layout } from "../../components/Layout";
import { Feed } from "../../components/Feed";
import { youtubeSchemaVideoToYouTubeVideo } from "../../dataMappers/youtubeSchemaVideoToYouTubeVideo";
import { FEED_ITEMS_PER_PAGE } from "../../config/constants";
import { hubs } from "../../hubs";

type Props = {
  hub: Hub;
  feedItems: FeedItem[];
  errors?: string;
};

export default class StaticPropsDetail extends React.Component<Props> {
  render(): JSX.Element {
    const { hub, feedItems } = this.props;

    return (
      <Layout title={`${hub ? hub.displayName : "User Detail"}`}>
        <Feed feedItems={feedItems} />
      </Layout>
    );
  }
}

export const getStaticPaths: GetStaticPaths = async () => {
  const paths = hubs.map((hub) => ({
    params: { id: hub.slug.toString() },
  }));

  return { paths, fallback: false };
};

export const getStaticProps: GetStaticProps = async ({ params }) => {
  try {
    const id = params?.id;

    const hub = hubs.find((hub) => hub.slug === id);

    const feedItems: FeedItem[] = [];

    for (const profile of hub?.profiles || []) {
      const videos: YouTubeVideo[] = (
        require(`../../profiles/${profile.slug}/youtube-videos-above-the-fold.generated.json`) ||
        []
      ).map(youtubeSchemaVideoToYouTubeVideo);

      feedItems.push(
        ...videos.map((video) => {
          return {
            video,
            profile,
          };
        })
      );
    }

    feedItems.sort((a, b) => {
      const firstPublishedAt = new Date((a.video && a.video.publishedAt) || "");
      const secondPublishedAt = new Date(
        (b.video && b.video.publishedAt) || ""
      );

      return +secondPublishedAt - +firstPublishedAt;
    });

    return {
      props: {
        hub,
        feedItems: feedItems.slice(0, FEED_ITEMS_PER_PAGE),
      },
    };
  } catch (err) {
    return { props: { errors: err.message } };
  }
};
