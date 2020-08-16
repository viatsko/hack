import * as React from "react";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core";

const useStyles = makeStyles((theme) => ({
  subject: {
    display: "block",
    paddingBottom: theme.spacing(2),
  },
}));

interface Props {
  title: string;
}

export function Subject(props: Props): JSX.Element {
  const classes = useStyles();

  return (
    <Typography
      component="span"
      variant="h5"
      color="textPrimary"
      className={classes.subject}
    >
      <strong dangerouslySetInnerHTML={{ __html: props.title }} />
    </Typography>
  );
}
