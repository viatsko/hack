class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        if (x == 0) {
            return true;
        }
        
        int numberOfDigits = (int)(Math.floor(Math.log10(x))) + 1;
        int mask = (int)(Math.pow(10, numberOfDigits - 1));
        
        // 121
        // 100
        
        for (int i = 0; i < numberOfDigits / 2; i++) {
            int left = x / mask;
            int right = x % 10;
            
            if (left != right) {
                return false;
            }
            
            x %= mask;
            x /= 10;
            mask /= 100;
        }
        
        return true;
    }
}
