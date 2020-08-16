import * as React from "react";
import Container, { ContainerTypeMap } from "@material-ui/core/Container";
import { makeStyles } from "@material-ui/core/styles";
import { Copyright } from "../copyright/Copyright";
import Head from "next/head";
import { Header } from "../header/Header";
import { HorizontalMenu } from "../horizontal-menu/HorizontalMenu";
import { mainMenu } from "../../menus/mainMenu";

const DEFAULT_CONTAINER_MAX_WIDTH = "lg";

interface OwnProps {
  title: string;
  img?: React.ReactNode;
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

  return (
    <>
      <Head>
        <title>{`${props.title} | League of Learning`}</title>
      </Head>
      <Header title={props.title} />
      <HorizontalMenu menuItems={mainMenu} />
      <Container maxWidth={containerMaxWidth} className={classes.offset}>
        {/* <Typography variant="h4" component="h2" gutterBottom={true}>
          {props.img} {props.title}
        </Typography> */}
        {props.children}
        <Copyright />
      </Container>
    </>
  );
}
