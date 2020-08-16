#include <cmath>

bool isLucky(int n) {
    unsigned int digits_count = ((n <= 1) ? 1 : log10(n) + 1);
    
    unsigned int first_half = 0;
    unsigned int second_half = 0;
    
    for (unsigned int i = 0; i < digits_count; i++) {
        if (i < digits_count / 2) {
            first_half += n % 10;
        } else {
            second_half += n % 10;
        }
        
        n /= 10;
    }
    
    return first_half == second_half;
}
