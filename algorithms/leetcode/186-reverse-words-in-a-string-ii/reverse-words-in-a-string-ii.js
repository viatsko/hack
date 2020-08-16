
const reverseWords = str => {
    let i = 0;
    let j = str.length - 1;
  
    while (i < j) {
        const tmp = str[i];
        str[i++] = str[j];
        str[j--] = tmp;
    }
  
    let lastword = 0;
    for (let i = 0; i < str.length; i++) {
        if (str[i + 1] === ' ' || i === str.length - 1) {
            let start = lastword;
            let end = i;
            
            while (start < end) {
                const tmp = str[start];
                str[start++] = str[end];
                str[end--] = tmp;
            }
            
            lastword = i + 2;
        }
    }
}
