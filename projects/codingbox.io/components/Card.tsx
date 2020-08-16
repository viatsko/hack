import * as React from "react";
import { default as MaterialUICard } from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import { makeStyles } from "@material-ui/core/styles";
import { Tidbit } from "./Tidbit";
import { Subject } from "./Subject";
import { Description } from "./Description";

const useStyles = makeStyles((theme) => ({
  root: {
    display: "flex",
    "&:not(:last-child)": {
      marginBottom: theme.spacing(4),
    },
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
}));

interface Props {
  title: string;
  description?: string;
  personaLink: string;
  personaPhotoPath: string;
  personaDisplayName: string;
  tidbitText: string;
  timestamp: Date;
  children?: React.ReactNode;
}

export function Card(props: Props): JSX.Element {
  const classes = useStyles();

  return (
    <MaterialUICard className={classes.root}>
      <div className={classes.details}>
        <CardContent className={classes.content}>
          <Tidbit
            personaLink={props.personaLink}
            personaPhotoPath={props.personaPhotoPath}
            personaDisplayName={props.personaDisplayName}
            tidbitText={props.tidbitText}
            timestamp={props.timestamp}
          />
          <Subject title={props.title} />
          {props.children}
          {props.description && <Description description={props.description} />}
        </CardContent>
      </div>
    </MaterialUICard>
  );
}
