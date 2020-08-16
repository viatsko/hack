import { ProfileSchema } from "../@types";

export function markReplays(profile: ProfileSchema) {
  profile.replays = true;
}
