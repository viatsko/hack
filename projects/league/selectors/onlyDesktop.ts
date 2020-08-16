import { Theme } from "@material-ui/core/styles";

export function onlyDesktop(theme: Theme): string {
  return theme.breakpoints.up("md");
}
