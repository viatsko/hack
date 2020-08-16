
const wordPatternMatch = (pattern, str) => {
    if (pattern.length === 0 && str.length === 0) return true;
    if (pattern.length === 0 || str.length === 0) return false;
    
    const patternMap = new Map();
    const stringMap = new Map();
    
    const match = (patternIndex, stringIndex) => {
        if (patternIndex === pattern.length && stringIndex === str.length) return true;
        if (patternIndex >= pattern.length || stringIndex >= str.length) return false;
        
        for (let stringEnd = stringIndex + 1; stringEnd <= str.length; stringEnd++) {
            const s = str.substring(stringIndex, stringEnd);
            const p = pattern[patternIndex];

            const prev_s = stringMap.get(s);
            const prev_p = patternMap.get(p);
            
            stringMap.set(s, patternIndex);
            patternMap.set(p, patternIndex);
            
            if (prev_s === prev_p) {
                if (match(patternIndex + 1, stringEnd)) {
                    return true;
                }
            }
            
            stringMap.set(s, prev_s);
            patternMap.set(p, prev_p);
        }
        
        return false;
    }
    
    return match(0, 0);
}
