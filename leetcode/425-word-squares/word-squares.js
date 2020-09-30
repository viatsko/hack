/**
 * @param {string[]} words
 * @return {string[][]}
 */
const wordSquares = function (words) {
  const dictionary = {};
  for (const word of words) {
    for (let i = 0; i <= word.length; i++) {
      const key = word.substring(0, i);
      if (!dictionary[key]) {
        dictionary[key] = [];
      }
      dictionary[key].push(word);
    }
  }

  const N = words[0].length;

  const boards = [];
  const board = new Array(N).fill("");
  const helper = (i) => {
    if (i === N) {
      boards.push(board.slice(0));
      return;
    }
    let prefix = "";
    for (let r = 0; r < i; r++) {
      prefix += board[r][i];
    }
    console.log(prefix);
    //console.log('pre', prefix);
    for (const word of dictionary?.[prefix] || []) {
      board[i] = word;
      //console.log(board);
      helper(i + 1);
    }
  };
  helper(0);
  return boards;
};
