import * as React from "react";
import Container, { ContainerTypeMap } from "@material-ui/core/Container";
import { makeStyles } from "@material-ui/core/styles";
import { TopBar } from "./TopBar";
import { SideNav, Section } from "./SideNav";
import Box from "@material-ui/core/Box";
import { Copyright } from "./Copyright";
import Typography from "@material-ui/core/Typography";
import profilesIndex from "../profiles-index.generated.json";
import { ProfileIndexSchema } from "../@types";
import Head from "next/head";
import { hubs } from "../hubs";

const DEFAULT_CONTAINER_MAX_WIDTH = "sm";

interface OwnProps {
  title: string;
  containerMaxWidth?: ContainerTypeMap["props"]["maxWidth"];
  children?: React.ReactNode;
}

type Props = OwnProps;

const useStyles = makeStyles((theme) => ({
  /* theme.spacing(5) if we use filter */
  offset: { ...theme.mixins.toolbar, paddingTop: theme.spacing(8) },
}));

export function Layout(props: Props): JSX.Element {
  const classes = useStyles();

  const containerMaxWidth =
    props.containerMaxWidth || DEFAULT_CONTAINER_MAX_WIDTH;

  const sections: Section[] = [
    {
      title: "Main menu",
      items: [
        {
          title: "Home",
          url: "/",
        },
        {
          title: "About",
          url: "/about",
        },
        {
          title: "Terms of Service",
          url: "/tos",
        },
      ],
    },
    {
      title: "Hubs",
      items: hubs.map((hub) => ({
        title: hub.displayName,
        url: `/hub/${hub.slug}`,
      })),
    },
    {
      title: "Profiles",
      items: (profilesIndex as ProfileIndexSchema).profiles.map((profile) => {
        return {
          title: profile.displayName,
          image: profile.avatar,
          url: `/u/${profile.slug}`,
        };
      }),
    },
  ];

  return (
    <>
      <Head>
        <title>{`${props.title} | CodingBox.io`}</title>
      </Head>
      <TopBar />
      <SideNav sections={sections} />
      <Container maxWidth={containerMaxWidth} className={classes.offset}>
        <Box my={4}>
          <Typography variant="h4" component="h2" gutterBottom={true}>
            {props.title}
          </Typography>
          {props.children}
          <Copyright />
        </Box>
      </Container>
    </>
  );
}
