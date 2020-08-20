
const wordPattern = (pattern, str) => {
    const conns = new Map();
    const unique = new Set();
    const words = str.split(' ');
    
    if (pattern.length !== words.length) {
        return false;
    }
    
    for (let i = 0; i < pattern.length; i++) {
        if (!conns.has(pattern[i]) && !unique.has(words[i])) {
            conns.set(pattern[i], words[i]);
            unique.add(words[i]);
        }
        
        if (conns.get(pattern[i]) !== words[i]) {
            return false;
        }
    }
    
    return true;
}
