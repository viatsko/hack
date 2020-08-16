import * as React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Background from "./image.jpg";
import BackgroundDesktop from "./image.jpg";
import Link from "next/link";
import Typography from "@material-ui/core/Typography";
import classNames from "classnames";
import { useMobile } from "../../hooks/useMobile";
import { onlyDesktop } from "../../selectors/onlyDesktop";
import { Fluid } from "../fluid/Fluid";
import { onlyMobile } from "../../selectors/onlyMobile";
import { useDesktop } from "../../hooks/useDesktop";

interface Props {
  title?: string;
}

export const useStyles = makeStyles((theme) => ({
  container: {
    backgroundPositionY: "20%",
    backgroundImage: `url(${Background})`,
    backgroundSize: `cover`,
    [onlyDesktop(theme)]: {
      backgroundImage: `url(${BackgroundDesktop})`,
    },
  },
  containerInner: {
    paddingTop: 40,
    [onlyMobile(theme)]: {
      paddingTop: 20,
      //padding: 20,
    },
    background: `linear-gradient(180deg, rgba(10, 20, 35, 0.34) 0%, rgba(10, 20, 35, 0.82) 72.4%, #0A1423 100%)`,
  },
  topLine: {
    display: "flex",
  },
  mobileLogo: {
    display: "flex",
    flex: 1,
  },
  title: {
    marginTop: 81,
    fontWeight: 900,
    fontSize: 31,
    lineHeight: "39px",
    color: "#F9FAFF",
    [onlyDesktop(theme)]: {
      marginTop: 134,
      fontSize: 64,
      lineHeight: "81px",
      maxWidth: 700,
    },
  },
  innerTitle: {
    textAlign: "center",
    [onlyDesktop(theme)]: {
      marginTop: 67,
      fontSize: 48,
      lineHeight: "60px",
      maxWidth: "none",
      whiteSpace: "nowrap",
      textOverflow: "ellipsis",
      overflow: "hidden",
    },
  },
  description: {
    fontWeight: 500,
    fontSize: 14,
    lineHeight: "150%",
    color: "#898F9D",
    marginTop: 14,
    [onlyDesktop(theme)]: {
      fontSize: 16,
      lineHeight: "150%",
      maxWidth: 450,
    },
  },
  ctas: {
    marginTop: 30,
    display: "flex",
    "& > *:first-child": {
      marginRight: 6,
    },
    "& > *:last-child": {
      marginLeft: 6,
    },
    [onlyDesktop(theme)]: {
      display: "inline-flex",
      "& > *": {
        width: 207,
        "& span": {
          fontSize: 16,
          lineHeight: "150%",
        },
      },
      "& > *:first-child": {
        marginRight: 9,
      },
      "& > *:last-child": {
        marginLeft: 9,
        border: "1px solid #F9FAFF",
        background: "transparent",
        "& span": {
          color: "#F9FAFF",
        },
        "&:hover": {
          background: "#F9FAFF",
          "& span": {
            color: theme.palette.primary.dark,
          },
        },
      },
    },
  },
  trustpilot: {
    marginTop: 44,
    display: "flex",
    justifyContent: "center",
    [onlyDesktop(theme)]: {
      marginTop: -50,
      justifyContent: "flex-end",
    },
  },
  breadcrumbs: {
    marginTop: 4,
    fontWeight: 600,
    fontSize: 14,
    lineHeight: "17px",
    textAlign: "center",
    color: "#FFFFFF",
    [onlyDesktop(theme)]: {
      marginTop: 16,
      fontSize: 18,
      lineHeight: "21px",
    },
  },
  breadCurrent: {
    color: "#898f9d",
  },
  logoWithSearchBox: {
    display: "flex",
  },
  logo: {
    textDecoration: "none",
    fontSize: 31,
    position: "absolute",
    lineHeight: "39px",
    color: "#F9FAFF",
    fontWeight: 900,
    [onlyDesktop(theme)]: {
      fontSize: 48,
      lineHeight: "60px",
    },
  },
}));

export function Header(props: Props): JSX.Element {
  const styles = useStyles();

  const isDesktop = useDesktop();

  const isMobile = useMobile();

  let headerHeight: string | number = "auto";

  if (isMobile) {
    headerHeight = 338;
  } else {
    headerHeight = 345;
  }

  return (
    <div className={styles.container} style={{ height: headerHeight }}>
      <div className={styles.containerInner} style={{ height: headerHeight }}>
        <Fluid extraPaddings>
          <div className={styles.topLine}>
            <div
              className={
                isDesktop ? styles.logoWithSearchBox : styles.mobileLogo
              }
            >
              <Link href={`/`}>
                <a style={{ display: "flex" }} className={styles.logo}>
                  LeagueOfLearning.io
                </a>
              </Link>
            </div>
          </div>
          <Typography
            variant="h2"
            className={classNames(styles.title, styles.innerTitle)}
          >
            {props.title}
          </Typography>
          <div className={styles.breadcrumbs}>
            <Link href="/" as="/">
              <span>Home</span>
            </Link>{" "}
            <span className={styles.breadCurrent}>/ {props.title}</span>
          </div>
        </Fluid>
      </div>
    </div>
  );
}
