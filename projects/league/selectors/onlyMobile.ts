import { Theme } from "@material-ui/core/styles";

export function onlyMobile(theme: Theme): string {
  return theme.breakpoints.down("sm");
}
