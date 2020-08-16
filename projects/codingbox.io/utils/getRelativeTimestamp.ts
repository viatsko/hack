/*
 * Based on Caio Tarifa vanilla js implementation
 * https://stackoverflow.com/questions/6108819/javascript-timestamp-to-relative-time-eg-2-seconds-ago-one-week-ago-etc-best
 */

const locales = {
  prefix: "",
  sufix: "ago",
  separator: " ",

  seconds: "less than a minute",
  minute: "about a minute",
  minutes: "%d minutes",
  hour: "about an hour",
  hours: "about %d hours",
  day: "a day",
  days: "%d days",
  month: "about a month",
  months: "%d months",
  year: "about a year",
  years: "%d years",
};

// eslint-disable-next-line @typescript-eslint/no-explicit-any
function hasKey<O>(obj: O, key: keyof any): key is keyof O {
  return key in obj;
}

export function getRelativeTimestamp(timeAgo: Date): string {
  const seconds = Math.floor((+new Date() - +timeAgo) / 1000);

  const separator = locales.separator || " ";

  let words = locales.prefix + separator;

  let interval = 0;

  const intervals = {
    year: seconds / 31104000,
    month: seconds / 2592000,
    day: seconds / 86400,
    hour: seconds / 3600,
    minute: seconds / 60,
  };

  let distance = locales.seconds;

  let localeKey = "";

  for (const [key, value] of Object.entries(intervals)) {
    interval = Math.floor(value);

    if (interval > 1) {
      localeKey = key + "s";
      break;
    } else if (interval === 1) {
      localeKey = key;
      break;
    }
  }

  if (hasKey(locales, localeKey)) distance = locales[localeKey];

  distance = distance.replace(/%d/i, `${interval}`);
  words += distance + separator + locales.sufix;

  return words.trim();
}
