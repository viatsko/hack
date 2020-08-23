// Top 1 voted solution rewritten in JS, just to keep such solution in memory
function numJewelsInStones(J, S) {
  return S.replace(new RegExp("[^"+J+"]", "g"), "").length;
};
