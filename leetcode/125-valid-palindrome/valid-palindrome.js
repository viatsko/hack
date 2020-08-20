
const isPalindrome = s => {
    const re = /[A-Za-z0-9]/;
    
    let i = 0;
    
    let j = s.length - 1;
    
    while(i < j) {
        if (!re.test(s[i])) {
            i++;
        } else if (!re.test(s[j])) {
            j--;
        } else if (s[i++].toLowerCase() !== s[j--].toLowerCase()) {
            return false;
        }
    }
    
    return true;
}
