import { ProfileSchema } from "../@types";

export function markRussian(profile: ProfileSchema) {
  profile.russian = true;
}
