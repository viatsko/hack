class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int even = 0;
        int odd = 1;
        
        while (even < A.length || odd < A.length) {
            while (even < A.length && (A[even] & 1) == 0) {
                even += 2;
            }
            
            while (odd < A.length && (A[odd] & 1) == 1) {
                odd += 2;
            }
            
            if (even >= A.length && odd >= A.length) {
                break;
            }
            
            int tmp = A[even];
            A[even] = A[odd];
            A[odd] = tmp;
        }
        
        return A;
    }
}
