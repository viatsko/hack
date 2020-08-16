
const licenseKeyFormatting = (s, k) => {
    const result = [];
    
    let buf = '';
    
    for (let i = s.length - 1; i >= 0; i--) {
        if (s[i] !== '-') {
            if (buf.length === k) {
                result.push(buf);
                
                buf = '';
            }
            
            buf += s[i];
        }
    }
    
    if (buf.length) {
        result.push(buf);
    }
    
    return result.join('-').split('').reverse().join('').toUpperCase();
}
