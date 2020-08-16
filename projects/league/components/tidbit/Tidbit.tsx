import * as React from "react";
import CardMedia from "@material-ui/core/CardMedia";
import Typography from "@material-ui/core/Typography";
import Link from "@material-ui/core/Link";
import { makeStyles } from "@material-ui/core/styles";
import { getRelativeTimestamp } from "../../utils/getRelativeTimestamp";

const useStyles = makeStyles((theme) => ({
  header: {
    display: "flex",
    flexDirection: "row",
    alignItems: "center",
    marginBottom: theme.spacing(2),
  },
  coverContainer: {
    minWidth: `calc(40px + ${theme.spacing(1)}px)`,
  },
  cover: {
    width: 60,
    height: 60,
    borderRadius: 100,
    marginRight: theme.spacing(1),
  },
  firstLine: {
    width: "100%",
    display: "flex",
    fontSize: 16,
  },
  info: {
    flex: 1,
  },
  secondLine: {},
  nickname: {
    flex: 1,
  },
  timestamp: {
    flex: 0,
    whiteSpace: "nowrap",
  },
  profileLink: {
    color: "inherit",
    textDecoration: "none",
  },
}));

interface Props {
  personaLink: string;
  personaPhotoPath: string;
  personaDisplayName: string;
  tidbitText: string;
  timestamp: Date;
}
export function Tidbit(props: Props): JSX.Element {
  const classes = useStyles();

  const now = new Date();
  const dt = new Date(props.timestamp || "");

  return (
    <div className={classes.header}>
      <div className={classes.coverContainer}>
        <Link href={props.personaLink}>
          <CardMedia
            className={classes.cover}
            image={props.personaPhotoPath}
            title="Persona photo"
          />
        </Link>
      </div>
      <div className={classes.info}>
        <div className={classes.firstLine}>
          <div className={classes.nickname}>
            <Link href={props.personaLink} className={classes.profileLink}>
              <strong>{props.personaDisplayName}</strong>
            </Link>{" "}
            {props.tidbitText}
          </div>
          <div className={classes.timestamp}>
            <Typography component="span" variant="body2" color="textSecondary">
              {dt < now
                ? getRelativeTimestamp(dt)
                : `${`${dt.getDate()}`.padStart(2, "0")}.${`${
                    dt.getMonth() + 1
                  }`.padStart(2, "0")}.${dt.getFullYear()}`}
            </Typography>
          </div>
        </div>
        <div className={classes.secondLine} />
      </div>
    </div>
  );
}
