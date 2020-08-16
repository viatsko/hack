import { createMuiTheme, StyleRules, fade } from "@material-ui/core/styles";

const DEFAULT_FONT_FAMILY = `-apple-system, BlinkMacSystemFont, "Segoe UI", "Roboto", "Oxygen", "Ubuntu", "Cantarell", "Fira Sans", "Droid Sans", "Helvetica Neue", sans-serif`;

const GREEN = "#336699";
const DARK_GREEN = "#336666";

const theme = createMuiTheme({
  breakpoints: {
    values: {
      xs: 0,
      sm: 600,
      md: 960,
      lg: 1420,
      xl: 1630,
    },
  },
  palette: {
    type: "dark",
    primary: { main: GREEN, dark: DARK_GREEN, contrastText: "#fff" },
  },
  typography: {
    fontFamily: `Gilroy,${DEFAULT_FONT_FAMILY}`,
    fontSize: 16,
    h1: {
      fontFamily: `DINPro,${DEFAULT_FONT_FAMILY}`,
    },
    h2: {
      fontFamily: `DINPro,${DEFAULT_FONT_FAMILY}`,
    },
    h3: {
      fontFamily: `DINPro,${DEFAULT_FONT_FAMILY}`,
    },
    h4: {
      fontFamily: `DINPro,${DEFAULT_FONT_FAMILY}`,
    },
    h5: {
      fontFamily: `DINPro,${DEFAULT_FONT_FAMILY}`,
    },
    h6: {
      fontFamily: `DINPro,${DEFAULT_FONT_FAMILY}`,
    },
  },
  overrides: {
    MuiButton: {
      root: {
        width: "100%",
        fontWeight: "bold",
        fontSize: 16,
        lineHeight: "150%",
        display: "flex",
        alignItems: "center",
        textAlign: "center",
        textTransform: "uppercase",
        ...Transitions.DEFAULT,
        "&:hover": {
          background: DARK_GREEN,
        },
      },
    },
    MuiCheckbox: {
      root: {
        "&:hover": {
          backgroundColor: "transparent",
        },
      },
    },
    MuiIconButton: {
      label: {},
    },
    MuiInput: {
      root: {
        "&:not(:first-of-type)": {
          marginTop: 12,
        },
        width: "100%",
      },
      input: {
        padding: "14px 16px",
        border: `1px solid ${fade("#898F9D", 0.6)}`,
        borderRadius: "5px",
        width: "100%",
        fontWeight: 500,
        fontSize: 14,
        lineHeight: "150%",
        display: "flex",
        alignItems: "center",
        color: fade("#0A1423", 0.7),
        "&::placeholder": {
          opacity: 1,
          color: "#848992",
        },
      },
    },
    MuiInputLabel: {
      root: {
        fontWeight: "bold",
        fontSize: 16,
        lineHeight: "150%",
        textTransform: "uppercase",
        color: "#0A1423",
      },
    },
    MuiFormControlLabel: {
      root: {
        marginTop: 3,
        marginLeft: -8,
      },
      label: {
        fontWeight: 600,
        fontSize: 14,
        lineHeight: "17px",
        color: fade("#0A1423", 0.7),
      },
    },
    MuiMenuItem: {
      root: {
        fontWeight: 600,
        fontSize: 14,
        lineHeight: "17px",
        color: fade("#0A1423", 0.7),
        paddingTop: 12,
        paddingBottom: 12,
        paddingLeft: 16,
        paddingRight: 16,
        "&$selected": {
          backgroundColor: `${fade(GREEN, 0.08)} !important`,
        },
        "&:not(:last-child)": {
          borderBottom: `1px solid ${fade("#898F9D", 0.5)}`,
        },
      },
    },
    MuiMenu: {
      list: {
        paddingTop: 0,
        paddingBottom: 0,
        overflow: "hidden",
        borderRadius: 4,
        border: `1px solid ${fade("#898F9D", 0.5)}`,
      },
    },
    MuiSelect: {
      root: {
        width: "100%",
        fontWeight: 600,
        fontSize: 14,
        paddingTop: 12,
        paddingBottom: 12,
        paddingLeft: 16,
        lineHeight: "17px",
        color: fade("#0A1423", 0.7),
      },
      outlined: {
        background: "#fff",
      },
      select: {
        backgroundColor: "#fff",
        "&:focus": {
          backgroundColor: "#fff",
        },
      },
    },
    MuiInputBase: {
      input: {
        height: "auto",
      },
    },
  },
  props: {
    MuiButton: {
      disableElevation: true,
    },
    MuiCheckbox: {},
    MuiInput: {
      disableUnderline: true,
    },
    MuiLink: {
      underline: "always",
    },
    MuiMenu: {
      elevation: 0,
    },
    MuiWithWidth: {
      initialWidth: "lg",
    },
  },
});

import { withStyles } from "@material-ui/core/styles";
import { Transitions } from "../components/transitions/Transitions";

const styles = (): StyleRules => ({
  "@global": {
    body: {
      background: "#060B14",
      margin: 0,
      ...{
        "-webkit-font-smoothing": "antialiased",
        "-moz-osx-font-smoothing": "grayscale",
      },
    },
    sup: {
      position: "relative",
      padding: 0,
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
