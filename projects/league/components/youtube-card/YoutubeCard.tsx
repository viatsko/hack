import * as React from "react";
import { default as MaterialUICard } from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import { makeStyles } from "@material-ui/core/styles";
import { Tidbit } from "../tidbit/Tidbit";
import { Subject } from "../subject/Subject";
import { Description } from "../description/Description";
import { YouTubeVideo } from "../../@types";

const useStyles = makeStyles((theme) => ({
  root: {
    display: "flex",
    // "&:not(:last-child)": {
    //   marginBottom: theme.spacing(4),
    // },
    maxHeight: 600,
    overflow: "hidden",
  },
  details: {
    flex: "1",
    display: "flex",
    flexDirection: "column",
  },
  content: {
    flex: "1 0 auto",
  },
  uploadForm: {
    marginTop: theme.spacing(2),
  },
  videoPreview: {
    marginTop: theme.spacing(3),
    marginBottom: theme.spacing(1),
    width: "calc(100% + 32px)",
    marginLeft: -16,
    marginRight: -16,
  },
  cardHeader: {
    height: 110,
  },
}));

interface Props {
  personaLink: string;
  personaPhotoPath: string;
  personaDisplayName: string;
  tidbitText: string;
  timestamp: Date;
  video: YouTubeVideo;
}

export function YoutubeCard(props: Props): JSX.Element {
  const styles = useStyles();

  const youtubeLink = `https://youtu.be/${props.video.videoId}`;

  return (
    <MaterialUICard className={styles.root}>
      <div className={styles.details}>
        <CardContent className={styles.content}>
          <div className={styles.cardHeader}>
            <Tidbit
              personaLink={props.personaLink}
              personaPhotoPath={props.personaPhotoPath}
              personaDisplayName={props.personaDisplayName}
              tidbitText={props.tidbitText}
              timestamp={props.timestamp}
            />
            <Subject title={props.video.title} url={youtubeLink} />
          </div>
          <a href={youtubeLink} target="_blank">
            <img
              loading="lazy"
              className={styles.videoPreview}
              src={props.video.preview}
            />
          </a>
          {props.video.description && (
            <Description
              shouldFold={false}
              description={props.video.description}
            />
          )}
        </CardContent>
      </div>
    </MaterialUICard>
  );
}
