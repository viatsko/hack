
const shortestDistance = (words, word1, word2) => {
    let pos1 = false;
    let pos2 = false;
    let min = Number.POSITIVE_INFINITY;

    for (let i = 0; i < words.length; i++) {
        if (words[i] === word1) {
            pos1 = i;
        }

        if (words[i] === word2) {
            pos2 = i;
        }

        if (pos1 !== false && pos2 !== false) {
            min = Math.min(Math.abs(pos2 - pos1), min);
        }
    }

    return min;
}
