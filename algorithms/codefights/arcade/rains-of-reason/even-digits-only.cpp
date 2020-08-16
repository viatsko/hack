bool evenDigitsOnly(int n) {
    while (n > 0) {
        if (n % 2 == 1) {
            return false;
        }
        
        n = n / 10;
    }
    
    return true;
}
