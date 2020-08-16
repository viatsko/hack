import profilesIndexJson from "../profiles-index.generated.json";
import { ProfileIndexSchema, Hub } from "../@types";

const tagToProfiles = new Map<string, ProfileIndexSchema["profiles"]>();

for (const profile of (profilesIndexJson as ProfileIndexSchema).profiles) {
  for (const tag of profile.tags) {
    let entry = tagToProfiles.get(tag);

    if (!entry) {
      entry = [];
    }

    entry.push(profile);

    tagToProfiles.set(tag, entry);
  }
}

const hubs: Hub[] = [];

export { hubs };
