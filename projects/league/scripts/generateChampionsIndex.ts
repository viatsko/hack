import * as fs from "fs";

const CHAMPIONS_INDEX_FILE = `${__dirname}/../champions-index.generated.json`;
const CHAMPIONS_REMAP_FILE = `${__dirname}/../champions-remap.generated.json`;

const champions = require("lol-champions/champions.json");

const championsHash: { [id: string]: any } = {};
const championsRemap: { [id: string]: string } = {};

for (const champion of champions) {
  if (champion.name === "Lux") {
    champion.redditUrl = "lux";
  } else if (champion.name === "Nunu & Willump") {
    champion.redditUrl = "NunuMains";
  } else if (champion.name === "Teemo") {
    champion.redditUrl = "TeemoTalk";
  } else {
    champion.redditUrl = champion.name.replace(/('|\s|\.|\&)/g, "") + "mains";
  }
  championsHash[champion.id] = champion;
  championsRemap[champion.id] = champion.id;
  championsRemap[champion.name.toLowerCase()] = champion.id;
  championsRemap[champion.name.replace(/'/g, " ").toLowerCase()] = champion.id;
}

fs.writeFileSync(CHAMPIONS_INDEX_FILE, JSON.stringify(championsHash, null, 2));
fs.writeFileSync(CHAMPIONS_REMAP_FILE, JSON.stringify(championsRemap, null, 2));
