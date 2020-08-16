
const isOneEditDistance = (s, t) => {
    for (let i = 0; i < Math.min(s.length, t.length); i++) {
        if (s[i] !== t[i]) {
            if (s.length === t.length) {
                return s.substr(i + 1) === t.substr(i + 1);
            } else if (s.length > t.length) {
                return s.substr(i + 1) === t.substr(i);
            } else {
                return t.substr(i + 1) === s.substr(i);
            }
        }
    }
    
    return Math.abs(s.length - t.length) === 1;
}
