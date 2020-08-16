import * as React from "react";
import { MenuItem } from "../../menus/mainMenu";
import { Fluid } from "../fluid/Fluid";
import { makeStyles, fade } from "@material-ui/core/styles";
import ChevronDownSVG from "./chevron-down.svg";
import { Transitions } from "../transitions/Transitions";
import ChevronUpSVG from "./chevron-up.svg";
import classNames from "classnames";
import { useMobile } from "../../hooks/useMobile";
import { DotSvg } from "./DotSvg";
import { StyledLink } from "../styled-link/StyledLink";
import { onlyDesktop } from "../../selectors/onlyDesktop";
import ListItemAvatar from "@material-ui/core/ListItemAvatar";
import Avatar from "@material-ui/core/Avatar";

interface Props {
  menuItems: MenuItem[];
}

const useStyles = makeStyles((theme) => ({
  container: {
    paddingLeft: 20,
    paddingRight: 20,
    zIndex: 100,
    position: "relative",
  },
  menuContainer: {
    position: "relative",
    background: theme.palette.common.white,
    boxShadow: "0px 5px 25px rgba(10, 20, 35, 0.15)",
    borderRadius: 10,
    height: 60,
    marginTop: -30,
    display: "flex",
    [onlyDesktop(theme)]: {
      justifyContent: "space-between",
    },
  },
  menuItem: {
    flex: "1",
    display: "flex",
    color: "#0A1423",
    paddingLeft: 12,
    paddingRight: 12,
    cursor: "pointer",
    ...Transitions.FASTER,
    "& > div": {
      display: "none",
    },
    "&:not(:last-child)": {
      borderRight: `1px solid ${fade("#0A1423", 0.1)}`,
    },
    "&:first-child": {
      borderTopLeftRadius: 10,
      borderBottomLeftRadius: 10,
    },
    "&:last-child": {
      borderTopRightRadius: 10,
      borderBottomRightRadius: 10,
    },
    "&:hover": {
      background: theme.palette.primary.main,
      color: theme.palette.common.white,
      "& > div": {
        display: "block",
        "&[data-wide]": {
          display: "flex",
        },
      },
      "& a::after": {
        top: 1,
        background: `url(${ChevronUpSVG})`,
      },
    },
  },
  menuItemNormal: {
    position: "relative",
  },
  menuItemWide: {},
  menuItemLink: {
    textDecoration: "none",
    whiteSpace: "nowrap",
    flex: 1,
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    fontWeight: 600,
    fontSize: 16,
    lineHeight: "19px",
    ...Transitions.FASTER,
    color: "inherit",
    "&::after": {
      marginLeft: 5,
      content: "''",
      position: "relative",
      top: 2,
      width: 9,
      height: 6,
      background: `url(${ChevronDownSVG})`,
    },
  },
  childMenu: {
    position: "absolute",
    top: 60,
    background: "#FFFFFF",
    //border: 1px solid #E7E8E9;
    boxSizing: "border-box",
    boxShadow: "0px 5px 25px rgba(10, 20, 35, 0.15)",
    borderBottomLeftRadius: 5,
    borderBottomRightRadius: 5,
    minWidth: 168,
  },
  childMenuWide: {
    flexDirection: "row",
    left: 5,
    right: 5,
    display: "flex",
    padding: 30,
  },
  childSubMenu: {
    flex: 1,
    "&:not(:first-child)": {
      paddingLeft: 30,
    },
    "&:not(:last-child)": {
      paddingRight: 30,
      borderRight: "1px solid #E7E8E9",
    },
  },
  childItem: {
    ...Transitions.FASTER,
    "&:not(:first-child)": {
      borderTop: "1px solid #E7E8E9",
    },
    padding: "12px 20px",
    display: "flex",
    whiteSpace: "nowrap",
    color: "#0A1423",
    "&:hover": {
      color: theme.palette.primary.main,
    },
  },
  childItemWide: {
    borderTop: "none !important",
  },
  childItemLink: {
    ...Transitions.FASTER,
    display: "flex",
    flex: 1,
    fontWeight: 600,
    fontSize: 16,
    lineHeight: "19px",
    textDecoration: "none",
    color: "inherit",
  },
  dot: { position: "relative", left: -7, top: -4 },
  productCard: {
    whiteSpace: "normal",
    border: "1px solid #E7E8E9",
    borderRadius: 10,
  },
  avatar: {
    width: 24,
    height: 24,
  },
  listItemAvatar: {
    minWidth: 32,
  },
}));

export function HorizontalMenu(props: Props): JSX.Element {
  const styles = useStyles();

  const isMobile = useMobile();

  return (
    <Fluid>
      <div className={styles.container}>
        <div className={styles.menuContainer} id="mainMenuContainer">
          {props.menuItems.map((menuItem, index) => {
            return (
              <div
                className={classNames(
                  styles.menuItem,
                  (!menuItem.wideChildren || isMobile) && styles.menuItemNormal,
                  menuItem.wideChildren && !isMobile && styles.menuItemWide
                )}
                data-hoverable-element
                key={`menu-item-${index}`}
              >
                <StyledLink
                  as={`/`}
                  href={menuItem.url}
                  className={styles.menuItemLink}
                >
                  {menuItem.title}
                </StyledLink>
                {(!menuItem.wideChildren || isMobile) && (
                  <div data-child-menu className={classNames(styles.childMenu)}>
                    {menuItem.children?.map((childItem, childIndex) => {
                      return (
                        <div
                          className={styles.childItem}
                          key={`menu-item-${index}-child-${childIndex}`}
                        >
                          <StyledLink
                            href={childItem.url}
                            className={styles.childItemLink}
                          >
                            {childItem.title}
                          </StyledLink>
                        </div>
                      );
                    })}
                  </div>
                )}
                {menuItem.wideChildren && !isMobile && (
                  <div
                    className={classNames(
                      styles.childMenu,
                      styles.childMenuWide
                    )}
                    data-child-menu
                    data-wide
                  >
                    {menuItem.wideChildren.map(
                      (children, childrenUpperIndex) => {
                        return (
                          <div
                            className={styles.childSubMenu}
                            key={`menu-item-${index}-child-${childrenUpperIndex}`}
                          >
                            {children?.map((childItem, childIndex) => {
                              return (
                                <div
                                  className={classNames(
                                    styles.childItem,
                                    styles.childItemWide
                                  )}
                                  key={`menu-item-${index}-child-${childIndex}`}
                                >
                                  {!childItem.product && (
                                    <StyledLink
                                      href={childItem.url}
                                      className={styles.childItemLink}
                                    >
                                      {childItem.image && (
                                        <ListItemAvatar
                                          className={styles.listItemAvatar}
                                        >
                                          <Avatar
                                            alt={childItem.title}
                                            className={styles.avatar}
                                            src={childItem.image}
                                          />
                                        </ListItemAvatar>
                                      )}
                                      {!childItem.image && (
                                        <>
                                          <span className={styles.dot}>
                                            <DotSvg />
                                          </span>{" "}
                                        </>
                                      )}
                                      {childItem.title}
                                    </StyledLink>
                                  )}
                                </div>
                              );
                            })}
                          </div>
                        );
                      }
                    )}
                  </div>
                )}
              </div>
            );
          })}
        </div>
      </div>
    </Fluid>
  );
}
