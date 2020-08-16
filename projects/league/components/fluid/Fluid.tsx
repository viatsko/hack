import * as React from "react";
import classNames from "classnames";
import { makeStyles } from "@material-ui/core/styles";

interface Props {
  children: React.ReactNode;
  extraPaddings?: boolean;
}

const useStyles = makeStyles(() => ({
  container: {
    maxWidth: 1440,
    margin: "0 auto",
  },
  containerExtraPaddings: {
    padding: "0 20px",
  },
}));

export function Fluid(props: Props): JSX.Element {
  const styles = useStyles();

  return (
    <div
      className={classNames(
        styles.container,
        props.extraPaddings && styles.containerExtraPaddings
      )}
    >
      {props.children}
    </div>
  );
}
