import champions from "../champions-index.generated.json";
import { ChampionSchema, ProfileIndexSchema } from "../@types";
import profilesIndex from "../profiles-index.generated.json";
import { chunkArray } from "../utils/chunkArray";

export interface MenuItem {
  readonly title?: string;
  readonly url?: string;
  readonly image?: string;
  readonly product?: string;
  readonly children?: MenuItem[];
  readonly wideChildren?: MenuItem[][];
}

const championsItems = Object.keys(champions).map((id) => {
  const champion = (champions as any)[id] as ChampionSchema;
  return {
    title: champion.name,
    image: champion.icon,
    url: `/champions/${id}`,
  };
});

const profilesItems = (profilesIndex as ProfileIndexSchema).profiles.map(
  (profile) => {
    return {
      title: profile.displayName,
      image: profile.avatar,
      url: `/u/${profile.slug}`,
    };
  }
);

const mainMenu: MenuItem[] = [
  {
    title: "Champions",
    url: "/",
    children: championsItems,
    wideChildren: chunkArray(championsItems, 6),
  },
  {
    title: "Profiles",
    url: "/",
    children: profilesItems,
    wideChildren: chunkArray(profilesItems, 4),
  },
  {
    title: "Placeholder",
    url: "/",
  },
  {
    title: "Placeholder 2",
    url: "/",
  },
];

export { mainMenu };
