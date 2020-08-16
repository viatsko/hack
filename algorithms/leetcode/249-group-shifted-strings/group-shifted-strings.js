
const groupStrings = strings => {
    const grouped = [];
    const aidx = 'a'.codePointAt(0);
    
    for (const s of strings) {
        const diff = s[0].codePointAt(0) - aidx;
        
        const rep = [];
        
        for (let i = 0; i < s.length; i++) {
            rep.push((s[i].codePointAt(0) - diff) % 26); // rotate if needed
        }

        const key = String.fromCharCode.apply(String, rep);
        
        if (!grouped[key]) grouped[key] = [];
        
        grouped[key].push(s);
    }
    
    return Object.values(grouped);
}
