import * as React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Typography from "@material-ui/core/Typography";
import Link from "@material-ui/core/Link";

const useStyles = makeStyles((theme) => ({
  copyright: {
    marginTop: theme.spacing(4),
  },
}));

export function Copyright(): JSX.Element {
  const classes = useStyles();

  return (
    <div className={classes.copyright}>
      <Typography variant="body2" color="textSecondary" align="center">
        {"Copyright © "}
        <Link color="inherit" href="mailto:viatsko@viatkso.me">
          Valerii Iatsko
        </Link>{" "}
        {new Date().getFullYear()}
      </Typography>
    </div>
  );
}
