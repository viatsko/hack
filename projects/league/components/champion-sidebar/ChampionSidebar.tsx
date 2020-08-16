import * as React from "react";
import { ChampionSchema } from "../../@types";
import { Sidebar } from "../sidebar/Sidebar";

interface Props {
  champion: ChampionSchema;
}

export function ChampionSidebar(props: Props): JSX.Element {
  return (
    <Sidebar
      title={props.champion?.name}
      menuItems={[
        {
          title: `Summary`,
          url: `/champions/${props.champion?.id}`,
        },
        {
          title: `Videos`,
          url: `/champions/${props.champion?.id}/videos`,
        },
        {
          title: `Reddit`,
          url: `/champions/${props.champion?.id}/reddit`,
        },
        {
          title: `Discord`,
          url: "#",
        },
      ]}
    />
  );
}
