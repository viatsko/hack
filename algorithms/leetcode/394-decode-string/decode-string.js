
const c0 = '0'.codePointAt(0);
const c9 = '9'.codePointAt(0);

const decodeString = s => {
    let end = s.length;
    let index = 0;
    
    const decode = (count) => {
        let result = '';
        
        let num = '';
        
        while (index < end) {
            const ch = s[index].codePointAt(0);
            
            if (ch >= c0 && ch <= c9) {
                num += s[index];
            } else if (s[index] === '[') {
                index++;
                
                const n = parseInt(num, 10);
                
                const tmp = decode(n);
                
                for (let i = 0; i < n; i++) {
                    result += tmp;
                }
                
                num = '';
            } else if (s[index] === ']') {
                return result;
            } else {
                result += s[index];
            }
            
            index++;
        }
        
        return result;
    };
    
    return decode(1);
}
