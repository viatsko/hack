
const isHappy = n => {
    let number = n;
    let digit = 0;

    while (number > 6) {
        let sum = 0;
        
        while(number > 0) {
            digit = number % 10;
            sum += Math.pow(digit, 2);
            number = Math.floor(number / 10);
        }
        
        number = sum;
    }
    
    return number === 1;
}
