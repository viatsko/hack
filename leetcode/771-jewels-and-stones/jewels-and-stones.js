function numJewelsInStones(J, S) {
  let result = 0;
  const s = [];
  for (const ch of S) {
    console.log(ch);
    s[ch] = -~s[ch];
  }
  for (const ch of J) {
    result += (s[ch] || 0);
  }
  return result;
};
