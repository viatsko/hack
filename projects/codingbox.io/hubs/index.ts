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

const hubs: Hub[] = [
  {
    displayName: "Algorithms",
    slug: "algorithms",
    profiles: tagToProfiles.get("algorithms") || [],
  },
  {
    displayName: "Amazon",
    slug: "amazon",
    profiles: tagToProfiles.get("amazon") || [],
  },
  {
    displayName: "Apple",
    slug: "apple",
    profiles: tagToProfiles.get("apple") || [],
  },
  {
    displayName: "Competitive Progamming",
    slug: "competitive_programming",
    profiles: tagToProfiles.get("competitive_programming") || [],
  },
  {
    displayName: "Google",
    slug: "google",
    profiles: tagToProfiles.get("google") || [],
  },
  {
    displayName: "Maths",
    slug: "maths",
    profiles: tagToProfiles.get("maths") || [],
  },
  {
    displayName: "Progamming Interviews",
    slug: "programming_interviews",
    profiles: tagToProfiles.get("programming_interviews") || [],
  },
  {
    displayName: "Startups & New Technologies",
    slug: "startups",
    profiles: tagToProfiles.get("startups") || [],
  },
  {
    displayName: "Relocation / Canada",
    slug: "relocation_canada",
    profiles: tagToProfiles.get("relocation:canada") || [],
  },
  {
    displayName: "Relocation / Norway",
    slug: "relocation_norway",
    profiles: tagToProfiles.get("relocation:norway") || [],
  },
  {
    displayName: "Relocation / USA",
    slug: "relocation_us",
    profiles: tagToProfiles.get("relocation:us") || [],
  },
];

export { hubs };
