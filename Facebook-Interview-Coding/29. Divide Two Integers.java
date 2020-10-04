29. Divide Two Integers
// https://leetcode.com/problems/divide-two-integers/

Suppose we want to divide 15 by 3, so 15 is dividend and 3 is divisor. Well, division simply requires us to find how many times we can subtract the divisor from the the dividend without making the dividend negative.
We subtract 3 from 15 and we get 12, which is positive. Then, we shift 3 to the left by 1 bit and we get 6. 
Subtracting 6 from 15 still gives a positive result. Well, we shift again and get 12. 
We subtract 12 from 15 and it is still positive. We shift again, obtaining 24 and we know we can at most subtract 12. 
Well, since 12 is obtained by shifting 3 to left twice, we know it is 4 times of 3. How do we obtain this 4? 
Well, we start from 1 and shift it to left twice at the same time. We add 4 to an answer (initialized to be 0). 
In fact, the above process is like 15 = 3 * 4 + 3. We now get part of the quotient (4), with a remainder 3.
Then we repeat the above process again. We subtract divisor = 3 from the remaining dividend = 3 and obtain 0. 
We know we are done. No shift happens, so we simply add 1 << 0 to the answer.

Test:
divisor = 0; // overflow
dividend = INT_MIN and divisor = -1 (because abs(INT_MIN) = INT_MAX + 1) // overflow

Solution 1 (without multiply or division): Bit Manipulation
Time: O((logn)^2)
// The outer loop reduces n by at least half each iteration. So It has O(log N) iterations.
// The inner loop has at most log N iterations. So the overall complexity is O((logN)^2)
n
public int divide(int dividend, int divisor) {
    if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)
        return Integer.MAX_VALUE;
    int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
    long dvd = Math.abs((long) dividend);
    long dvs = Math.abs((long) divisor);
    int res = 0;
    while (dvd >= dvs) {
        long tmp = dvs, multiple = 1;
        while (dvd >= (tmp << 1)) {
            tmp <<= 1;
            multiple <<= 1;
        }
        dvd -= tmp;
        res += multiple;
    }
    return sign == 1 ? res : -res;
}

注意，此题所有用long的地方都是必须的！！
1.long dvd = Math.abs((long) dividend); // 里面(long) dividend是为了防止 -2147483648 取绝对值overflow变成0 
2.long tmp = dvs, multiple = 1; // 这个long和上面表达式最左边的long都是为了防止移位overflow，如 2147483647 << 1 变成 -2147483648，-2147483648再<<1就变成0，从而造成死循环




Solution 2 (with multiply): Binary Search
Time: O(logn)

public int divide(int dividend, int divisor) {
    if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)
        return Integer.MAX_VALUE;
    int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
    long dvd = Math.abs((long) dividend);
    long dvs = Math.abs((long) divisor);
    long l = 1, r = dvd;
    while (l < r) {
    	long mid = l + (r - l) / 2 + 1;
    	if (mid * dvs <= dvd)	l = mid;
    	else	r = mid - 1;
    }
    return sign == 1 ? (int) l : (int) -l;
}


Solution 3: 不用bit Manipulation，只用加减法做
public int divison(int num, int deno){ 
    if (deno == 0 || (deno == -1 && num == Integer.MIN_VALUE))   return Integer.MAX_VALUE;
    int sign = ((n < 0) ^ (d < 0)) ? -1 : 1;
    long n = Math.abs((long) num), d = Math.abs((long) deno);
    int res = 0;
    while (n >= d){
        n -= d;
        res++;
    }
    return res * sign;
}









