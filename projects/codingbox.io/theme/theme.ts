import { createMuiTheme, StyleRules } from "@material-ui/core/styles";

const theme = createMuiTheme({
  typography: {
    fontFamily: `-apple-system, BlinkMacSystemFont, "Segoe UI", "Roboto", "Oxygen", "Ubuntu", "Cantarell", "Fira Sans", "Droid Sans", "Helvetica Neue", sans-serif`,
    fontSize: 16,
  },
});

import { withStyles } from "@material-ui/core/styles";

const styles = (): StyleRules => ({
  "@global": {
    body: {
      background: "#f5f5f5",
      margin: 0,
      ...{
        "-webkit-font-smoothing": "antialiased",
        "-moz-osx-font-smoothing": "grayscale",
      },
    },
    // a: {
    //   color: "#2a7ae2",
    //   boxShadow: "none",
    //   textDecoration: "none",
    //   fontWeight: "normal",
    //   "&:visited": {
    //     color: "#1756a9",
    //   },
    //   "&:hover": {
    //     color: "#111",
    //     textDecoration: "underline",
    //   },
    // },
  },
});

function CssBaselineBase(): null {
  return null;
}

const MyCssBaseline = withStyles(styles)(CssBaselineBase);

export { theme, MyCssBaseline };
