import * as fs from "fs";
import { ProfileSchema, ProfileIndexSchema } from "../@types";

const PROFILES_DIR = `${__dirname}/../profiles`;

const PROFILES_INDEX_FILE = `${__dirname}/../profiles-index.generated.json`;

(async function (): Promise<void> {
  const profiles = fs.readdirSync(PROFILES_DIR);

  const profilesIndexJson: ProfileIndexSchema = {
    profiles: [],
  };

  for (const profile of profiles) {
    const profileJsonData: ProfileSchema = JSON.parse(
      fs.readFileSync(`${PROFILES_DIR}/${profile}/profile.json`, {
        encoding: "utf8",
        flag: "r",
      })
    );

    profilesIndexJson.profiles.push({
      tags: profileJsonData.tags || [],
      slug: profile,
      displayName: profileJsonData.displayName,
      avatar: profileJsonData.thumbnails.default.url,
    });
  }

  profilesIndexJson.profiles.sort((a, b) =>
    a.displayName.localeCompare(b.displayName)
  );

  fs.writeFileSync(
    PROFILES_INDEX_FILE,
    JSON.stringify(profilesIndexJson, null, 2)
  );
})();
