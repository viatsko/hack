import * as React from "react";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core";
import classNames from "classnames";

const useStyles = makeStyles((_theme) => ({
  subject: {
    display: "block",
    fontSize: 16,
    height: 42,
    overflow: "hidden",
    textOverflow: "ellipsis",
  },
  subjectNoCut: {
    height: "auto",
  },
  link: {
    textDecoration: "none",
    color: "inherit",
  },
  bigger: {
    fontSize: 24,
  },
}));

interface Props {
  title: string;
  url?: string;
  noCut?: boolean;
  bigger?: boolean;
}

export function Subject(props: Props): JSX.Element {
  const classes = useStyles();

  return (
    <Typography
      component="span"
      variant="h5"
      color="textPrimary"
      className={classNames(
        classes.subject,
        props.noCut && classes.subjectNoCut,
        props.bigger && classes.bigger
      )}
    >
      {props.url ? (
        <a href={props.url} target="_blank" className={classes.link}>
          <strong dangerouslySetInnerHTML={{ __html: props.title }} />
        </a>
      ) : (
        <strong dangerouslySetInnerHTML={{ __html: props.title }} />
      )}
    </Typography>
  );
}
