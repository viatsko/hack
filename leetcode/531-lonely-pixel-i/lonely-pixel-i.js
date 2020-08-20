
const findLonelyPixel = picture => {
    if (!picture.length || !picture[0].length) {
        return 0;
    }
    
    let rows = new Array(picture.length);
    
    let cols = new Array(picture[0].length);
    
    for (let i = 0; i < rows.length; i++) {
        for (let j = 0; j < cols.length; j++) {
            if (picture[i][j] === 'B') {
                rows[i] = -~rows[i];
                cols[j] = -~cols[j];
            }
        }
    }
    
    let result = 0;
    
    for (let i = 0; i < rows.length; i++) {
        for (let j = 0; j < cols.length; j++) {
            if (picture[i][j] === 'B' && rows[i] === 1 && cols[j] === 1) {
                result++;
            }
        }
    }
    
    return result;
}
