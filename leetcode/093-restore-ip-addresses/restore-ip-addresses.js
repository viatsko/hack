const isValid = (segment) => {
  if (segment[0] === "0") {
    return segment.length === 1;
  }
  return +segment >= 0 && +segment <= 255;
};

/**
 * @param {string} s
 * @return {string[]}
 */
const restoreIpAddresses = function (s) {
  const result = [];

  const segments = [];

  const helper = (start) => {
    if (start >= s.length) return;

    if (segments.length === 3) {
      if (isValid(s.substring(start))) {
        segments.push(s.substring(start));
        result.push([...segments].join("."));
        segments.pop();
      }
      return;
    }

    for (let i = start; i < start + 3; i++) {
      const candidate = s.substring(start, i + 1);

      if (isValid(candidate)) {
        segments.push(candidate);

        helper(i + 1);

        segments.pop();
      }
    }
  };

  helper(0);

  return result;
};
