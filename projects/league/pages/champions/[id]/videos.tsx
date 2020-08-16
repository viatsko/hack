import React from "react";
import { GetStaticProps, GetStaticPaths } from "next";
import championsIndex from "../../../champions-index.generated.json";
import {
  YouTubeVideo,
  FeedItem,
  FeedItemProfile,
  ChampionSchema,
} from "../../../@types";
import { Layout } from "../../../components/layout/Layout";
import { Feed } from "../../../components/feed/Feed";
import { makeStyles } from "@material-ui/core/styles";
import { onlyDesktop } from "../../../selectors/onlyDesktop";
import { ChampionSidebar } from "../../../components/champion-sidebar/ChampionSidebar";
import Typography from "@material-ui/core/Typography";

type Props = {
  profile: FeedItemProfile;
  champion: ChampionSchema;
  feedItems: FeedItem[];
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
  feedItems,
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
            YouTube Videos About {champion.name}
          </Typography>
          <Feed feedItems={feedItems} />
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

    return {
      props: {
        profile,
        champion: championJsonData,
        feedItems: videos,
      },
    };
  } catch (err) {
    return { props: { errors: err.message } };
  }
};
