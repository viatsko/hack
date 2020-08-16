
const canPermutePalindrome = s => {
    const repeats = new Set();
    
    for (const c of s) {
        if (repeats.has(c)) {
            repeats.delete(c);
        } else {
            repeats.add(c);
        }
    }
    
    return repeats.size <= 1;
}
