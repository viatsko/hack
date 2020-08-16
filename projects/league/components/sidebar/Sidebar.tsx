import makeStyles from "@material-ui/core/styles/makeStyles";
import { MenuItem } from "../../menus/mainMenu";
import { onlyDesktop } from "../../selectors/onlyDesktop";
import { fade } from "@material-ui/core/styles";
import { VerticalMenu } from "../vertical-menu/VerticalMenu";
import { useMobile } from "../../hooks/useMobile";

interface Props {
  title: string;
  menuItems: MenuItem[];
}

export const useStyles = makeStyles((theme) => ({
  outerContainer: {
    background: "#FFFFFF",
    [onlyDesktop(theme)]: {
      // boxShadow: "0px 3px 35px rgba(191, 194, 208, 0.7)",
      borderRadius: 10,
    },
    overflow: "hidden",
  },
  header: {
    fontWeight: "bold",
    fontSize: 16,
    lineHeight: "19px",
    color: "#0A1423",
    padding: 20,
  },
  clickable: {
    cursor: "pointer",
  },
  container: {
    paddingBottom: 0,
  },
  activeChild: {
    background: `linear-gradient(90deg, ${fade("#4EB05A", 0.05)} 0%, ${fade(
      "rgba(78, 176, 90, 0)",
      0.05
    )} 100%)`,
    color: "#4EB05A",
  },
}));

export function Sidebar(props: Props): JSX.Element {
  const styles = useStyles();

  const isMobile = useMobile();

  return (
    <div className={styles.outerContainer}>
      {!isMobile && <div className={styles.header}>{props.title}</div>}
      <VerticalMenu
        containerClassName={styles.container}
        menuItems={props.menuItems}
      />
    </div>
  );
}
