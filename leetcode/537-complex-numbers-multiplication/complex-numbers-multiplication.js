
const complexNumberMultiply = (a, b) => {
    let [a1, a2] = a.split('+');
    let [b1, b2] = b.split('+');
    
    a1 = parseInt(a1, 10);
    a2 = parseInt(a2.slice(0, -1), 10);
    b1 = parseInt(b1, 10);
    b2 = parseInt(b2.slice(0, -1), 10);
    
    return (a1 * b1 - a2 * b2) + "+" + (a1 * b2 + a2 * b1) + "i";
}
