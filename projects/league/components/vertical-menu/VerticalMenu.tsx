import * as React from "react";
import { makeStyles } from "@material-ui/core/styles";
import ChevronSvg from "./chevron-down.svg";
import ChevronActiveSvg from "./chevron-down-active.svg";
import Link from "next/link";
import MaterialUILink from "@material-ui/core/Link";
import Zoom from "@material-ui/core/Zoom";
import EllipseHover from "./ellipse-hover.svg";
import EllipseNormal from "./ellipse-normal.svg";
import { MenuItem } from "../../menus/mainMenu";
import classNames from "classnames";

interface Props {
  menuItems: MenuItem[];
  containerClassName?: string;
}

export const useStyles = makeStyles((theme) => ({
  container: {
    paddingBottom: 10,
  },
  topItemContainer: {
    "&:first-child": {
      borderTop: "1px solid #E7E8E9",
    },
    borderBottom: "1px solid #E7E8E9",
    background: "#F8F9FF",
  },
  topItem: {
    padding: 20,
    fontWeight: 600,
    fontSize: 16,
    lineHeight: "19px",
    color: "#0A1423",
    background: "#fff",
    display: "flex",
    cursor: "pointer",
  },
  chevron: {
    display: "inline-block",
    marginLeft: "auto",
    width: "19px",
    height: "12px",
  },
  chevronActive: {
    transform: "rotate(180deg)",
  },
  link: {
    color: "inherit",
    textDecoration: "none",
  },
  activeTopItem: {
    background: theme.palette.primary.main,
    color: "#fff",
  },
  childItem: {
    padding: 20,
    paddingLeft: 40,
    fontWeight: 600,
    fontSize: 16,
    lineHeight: "19px",
    display: "flex",
    "&:not(:first-child)": {
      borderTop: "1px solid #E7E8E9",
    },
    "&:hover": {
      color: theme.palette.primary.main,
      "& span:before": {
        background: `url(${EllipseHover})`,
      },
    },
  },
  innerLink: {
    "&:before": {
      content: "''",
      width: 3,
      height: 3,
      display: "block",
      background: `url(${EllipseNormal})`,
      marginRight: 11,
    },
    color: "inherit",
    display: "flex",
    alignItems: "center",
  },
}));

export function VerticalMenu(props: Props): JSX.Element {
  const styles = useStyles();

  const [activeMenuItem, setActiveMenuItem] = React.useState<
    MenuItem | undefined
  >(undefined);

  return (
    <div className={classNames(styles.container, props.containerClassName)}>
      {props.menuItems.map((menuItem, index) => {
        const isActiveItem = menuItem === activeMenuItem;

        return (
          <div key={`menu-parent-${index}`} className={styles.topItemContainer}>
            <div
              className={classNames(
                styles.topItem,
                isActiveItem && styles.activeTopItem
              )}
              onClick={(): void => {
                menuItem.children?.length
                  ? setActiveMenuItem(isActiveItem ? undefined : menuItem)
                  : (window.location.href = menuItem.url || "");
              }}
            >
              <Link href={`${menuItem.url}`}>
                <MaterialUILink
                  className={styles.link}
                  onClick={(e: React.MouseEvent): void => e.stopPropagation()}
                >
                  {menuItem.title}
                </MaterialUILink>
              </Link>
              {menuItem.children?.length && (
                <img
                  className={classNames(
                    styles.chevron,
                    isActiveItem && styles.chevronActive
                  )}
                  src={isActiveItem ? ChevronActiveSvg : ChevronSvg}
                />
              )}
            </div>
            {isActiveItem && menuItem.children?.length && (
              <Zoom in={true} style={{ transitionDelay: "100ms" }}>
                <div>
                  {menuItem.children.map((menuItem, childIndex) => {
                    return (
                      <div
                        key={`menu-${index}-${childIndex}`}
                        className={styles.childItem}
                        onClick={(): void => {
                          window.location.href = menuItem.url || "";
                        }}
                      >
                        <span className={styles.innerLink}>
                          {menuItem.title}
                        </span>
                      </div>
                    );
                  })}
                </div>
              </Zoom>
            )}
          </div>
        );
      })}
    </div>
  );
}
