import { ProfileSchema } from "../@types";

export function addTag(profile: ProfileSchema, tag: string) {
  if (!profile.tags) {
    profile.tags = [];
  }

  profile.tags.push(tag);
}
