import React from "react";
import { GetStaticProps, GetStaticPaths } from "next";
import profilesIndex from "../../profiles-index.generated.json";
import {
  ProfileIndexSchema,
  YouTubeVideo,
  ProfileSchema,
  FeedItem,
  FeedItemProfile,
} from "../../@types";
import { Layout } from "../../components/layout/Layout";
import { Feed } from "../../components/feed/Feed";
import { youtubeSchemaVideoToYouTubeVideo } from "../../dataMappers/youtubeSchemaVideoToYouTubeVideo";
import { FEED_ITEMS_PER_PAGE } from "../../config/constants";

type Props = {
  profile: FeedItemProfile;
  feedItems: FeedItem[];
  errors?: string;
};

export default class StaticPropsDetail extends React.Component<Props> {
  render(): JSX.Element {
    const { profile, feedItems } = this.props;

    return (
      <Layout title={`${profile ? profile.displayName : "User Detail"}`}>
        <Feed feedItems={feedItems} count={4} />
      </Layout>
    );
  }
}

export const getStaticPaths: GetStaticPaths = async () => {
  const paths = (profilesIndex as ProfileIndexSchema).profiles.map(
    (profile) => ({
      params: { id: profile.slug.toString() },
    })
  );

  return { paths, fallback: false };
};

export const getStaticProps: GetStaticProps = async ({ params }) => {
  try {
    const id = params?.id;

    // eslint-disable-next-line @typescript-eslint/no-var-requires
    const profileJsonData: ProfileSchema = require(`../../profiles/${id}/index.tsx`)
      .default;

    const profile = {
      slug: id,
      displayName: profileJsonData.displayName,
      avatar: profileJsonData.thumbnails.medium?.url || "",
      russian: Boolean(profileJsonData.russian),
      replays: Boolean(profileJsonData.replays),
    };

    const videos: YouTubeVideo[] = (
      require(`../../profiles/${id}/youtube-videos-above-the-fold.generated.json`) ||
      []
    )
      .slice(0, FEED_ITEMS_PER_PAGE)
      .map(youtubeSchemaVideoToYouTubeVideo);

    return {
      props: {
        profile,
        feedItems: videos.map((video) => {
          return {
            video,
            profile,
          };
        }),
      },
    };
  } catch (err) {
    return { props: { errors: err.message } };
  }
};
