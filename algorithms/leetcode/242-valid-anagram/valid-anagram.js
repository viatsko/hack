
const isAnagram = (s, t) => {
    const chars = Array(26).fill(0);
    const acode = 'a'.codePointAt(0);
    
    for (const c of s) {
        const code = c.codePointAt(0) - acode;
        
        chars[code]++;
    }
    
    for (const c of t) {
        const code = c.codePointAt(0) - acode;
        
        chars[code]--;
        
        if (chars[code] < 0) {
            return false;
        }
    }
    
    for (const n of chars) {
        if (n > 0) {
            return false;
        }
    }
    
    return true;
}
