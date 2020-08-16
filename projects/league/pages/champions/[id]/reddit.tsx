import React from "react";
import { GetStaticProps, GetStaticPaths } from "next";
import championsIndex from "../../../champions-index.generated.json";
import {
  YouTubeVideo,
  FeedItem,
  FeedItemProfile,
  ChampionSchema,
  RedditItem,
} from "../../../@types";
import { Layout } from "../../../components/layout/Layout";
import { makeStyles } from "@material-ui/core/styles";
import { onlyDesktop } from "../../../selectors/onlyDesktop";
import { ChampionSidebar } from "../../../components/champion-sidebar/ChampionSidebar";
import Typography from "@material-ui/core/Typography";
import { RedditFeed } from "../../../components/reddit-feed/RedditFeed";

type Props = {
  profile: FeedItemProfile;
  champion: ChampionSchema;
  feedItems: FeedItem[];
  redditItems: RedditItem[];
  errors?: string;
};

const useStyles = makeStyles((theme) => ({
  container: {
    [onlyDesktop(theme)]: {
      display: "flex",
    },
  },
  leftCol: {
    [onlyDesktop(theme)]: {
      flex: 1,
      marginRight: 20,
    },
  },
  rightCol: {
    [onlyDesktop(theme)]: {
      flex: 3,
    },
  },
}));

export default function Page({
  profile,
  champion,
  redditItems,
}: Props): JSX.Element {
  const styles = useStyles();

  return (
    <Layout
      title={`${profile ? profile.displayName : "User Detail"}`}
      img={<img height={36} src={champion.icon} />}
    >
      <div className={styles.container}>
        <div className={styles.leftCol}>
          <ChampionSidebar champion={champion} />
        </div>
        <div className={styles.rightCol}>
          <Typography variant="h2" component="h2" gutterBottom={true}>
            {champion?.name} Featured Reddit Posts
          </Typography>
          <RedditFeed redditItems={redditItems} />
        </div>
      </div>
    </Layout>
  );
}

export const getStaticPaths: GetStaticPaths = async () => {
  const paths = Object.keys(championsIndex).map((id) => ({
    params: { id },
  }));

  return { paths, fallback: false };
};

export const getStaticProps: GetStaticProps = async ({ params }) => {
  try {
    const id = params?.id;

    // eslint-disable-next-line @typescript-eslint/no-var-requires
    const championJsonData: ChampionSchema = require(`../../../champions/${id}`)
      .default;

    const profile = {
      slug: id,
      displayName: championJsonData.name,
      avatar: championJsonData.icon,
    };

    const videos: YouTubeVideo[] = championJsonData.videos;

    const championRedditData: RedditItem[] = require(`../../../champions/${id}/_reddit.json`)?.data?.children?.map(
      (item: any) => item.data
    ) as RedditItem[];

    return {
      props: {
        profile,
        champion: championJsonData,
        feedItems: videos,
        redditItems: championRedditData,
      },
    };
  } catch (err) {
    return { props: { errors: err.message } };
  }
};
