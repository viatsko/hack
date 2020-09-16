/**
 * @param {string} s
 * @return {string}
 */
const reverseWords = function (s) {
  return (
    s
      .split(" ")
      .filter((w) => w !== "")
      // .reverse()
      .map((w) => w.split("").reverse().join(""))
      .join(" ")
  );
};
