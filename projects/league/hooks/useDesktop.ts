import useMediaQuery from "@material-ui/core/useMediaQuery";
import { useTheme } from "@material-ui/core/styles";

export function useDesktop(): boolean {
  const theme = useTheme();
  return useMediaQuery(theme.breakpoints.up("md"));
}
