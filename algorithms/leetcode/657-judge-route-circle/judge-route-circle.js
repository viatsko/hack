
const judgeCircle = moves => {
    let top = 0;
    let left = 0;
    
    for (let i = 0; i < moves.length; i++) {
        switch(moves[i]) {
            case 'U':
                top++;
                break;
            case 'D':
                top--;
                break;
            case 'L':
                left--;
                break;
            case 'R':
                left++;
                break;
        }
    }
    
    return top === 0 && left === 0;
}
