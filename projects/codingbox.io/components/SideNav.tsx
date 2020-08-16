import React from "react";
import { createStyles, Theme, makeStyles } from "@material-ui/core/styles";
import Drawer from "@material-ui/core/Drawer";
import Toolbar from "@material-ui/core/Toolbar";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import Divider from "@material-ui/core/Divider";
import ListSubheader from "@material-ui/core/ListSubheader";
import ListItemAvatar from "@material-ui/core/ListItemAvatar";
import Avatar from "@material-ui/core/Avatar";
import ListItemText from "@material-ui/core/ListItemText";
import Link from "next/link";
import { default as MaterialUILink } from "@material-ui/core/Link";

const drawerWidth = 240;

const useStyles = makeStyles((theme: Theme) =>
  createStyles({
    root: {
      display: "flex",
    },
    appBar: {
      zIndex: theme.zIndex.drawer + 1,
    },
    drawer: {
      width: drawerWidth,
      flexShrink: 0,
      [theme.breakpoints.down("sm")]: {
        width: 0,
        display: "none",
      },
    },
    drawerPaper: {
      width: drawerWidth,
    },
    drawerContainer: {
      overflow: "auto",
    },
    content: {
      flexGrow: 1,
      padding: theme.spacing(3),
    },
    avatar: {
      width: 30,
      height: 30,
    },
    link: {
      color: "inherit",
      textDecoration: "none",
      "&:hover": {
        textDecoration: "none",
      },
    },
  })
);

export interface Item {
  image?: string;
  imageAlt?: string;
  title: string;
  url: string;
}

export interface Section {
  title: string;

  items: Item[];
}

interface Props {
  sections: Section[];
}

export function SideNav(props: Props): JSX.Element {
  const classes = useStyles();

  return (
    <Drawer
      className={classes.drawer}
      variant="permanent"
      classes={{
        paper: classes.drawerPaper,
      }}
    >
      <Toolbar />
      <div className={classes.drawerContainer}>
        <List>
          {props.sections.map((section: Section, sectionIndex: number) => {
            return (
              <React.Fragment key={`section-${sectionIndex}`}>
                <ListItem key={`section-${sectionIndex}`}>
                  <ListSubheader disableGutters={true}>
                    {section.title}
                  </ListSubheader>
                </ListItem>
                {section.items.map((item: Item, itemIndex: number) => {
                  const internal = /^\/(?!\/)/.test(item.url);

                  if (internal) {
                    return (
                      <Link
                        href={item.url}
                        key={`section-${sectionIndex}-${itemIndex}`}
                      >
                        <ListItem
                          button={true}
                          component={MaterialUILink}
                          className={classes.link}
                        >
                          {item.image && (
                            <ListItemAvatar>
                              <Avatar
                                alt={item.imageAlt || item.title}
                                className={classes.avatar}
                                src={item.image}
                              />
                            </ListItemAvatar>
                          )}
                          <ListItemText primary={item.title} />
                        </ListItem>
                      </Link>
                    );
                  } else {
                    return (
                      <ListItem
                        button={true}
                        component={MaterialUILink}
                        key={`section-${sectionIndex}-${itemIndex}`}
                        href={item.url}
                        className={classes.link}
                        target="_blank"
                      >
                        {item.image && (
                          <ListItemAvatar>
                            <Avatar
                              alt={item.imageAlt || item.title}
                              className={classes.avatar}
                              src={item.image}
                            />
                          </ListItemAvatar>
                        )}
                        <ListItemText primary={item.title} />
                      </ListItem>
                    );
                  }
                })}
                {sectionIndex !== props.sections.length - 1 && (
                  <Divider key={`section-divider-${sectionIndex}`} />
                )}
              </React.Fragment>
            );
          })}
        </List>
      </div>
    </Drawer>
  );
}
