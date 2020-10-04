Power Mod

Calculates a to the power of b, mod c. 
(x*y)%z == ((x%z)*y)%z == (x*(y%z))%z 
Examples:
PowMod(2,3,5) = 2*2*2 % 5 = 8%5 =3
PowMod(3, 6, 7) = 3*3*3*3*3*3 % 7 = 729%7 =1. 
PowMod(16,16,5) = 1 

Solution: recursion
Time: O(logb)

public int powmod(int a , int b , int c){
    return pow(a, b) % c;               
}  
// double a
private int pow(int a, int b) {
	if (b == 0)		return 1;
	if (b % 2 == 0)		return pow(a * a, b / 2);
	else	return a * pow(a * a, b / 2);
}


50. Pow(x, n)

Solution 1: nested pow
public double myPow(double x, int n) {
    if (n < 0)  return (1 / x) * myPow(1 / x, -(n + 1)); // not myPow(1 / x, -n) -> will overflow when Integer.MIN_VALUE
    if (n == 0) return 1;
    if (n == 2) return x * x;
    if (n % 2 == 0)  return myPow(myPow(x, n / 2), 2);
    else    return x * myPow(myPow(x, n / 2), 2);
}


Solution 2: double x
public double myPow(double x, int n) {
    if (n == 0 || x == 1)     return 1; // necessary
    if (x == -1)    return n % 2 == 0 ? 1 : -1; // necessary
    if (n == Integer.MIN_VALUE) return 0;
    if (n < 0) {
        n = -n;
        x = 1 / x;
    }
    return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
}


Solution 3: double pow, recursive
public double myPow(double x, int n) {
    if (n == 0)     return 1;
    double tmp = myPow(x, n / 2);
    if (n % 2 == 0)     return tmp * tmp;
    else    return n < 0 ? 1 / x * tmp * tmp : x * tmp * tmp;
}


Solution 4: double pow, iterative
public double myPow(double x, int n) {
    if (n == 0 || x == 1)     return 1;
    if (x == -1)    return n % 2 == 0 ? 1 : -1;
    if (n == Integer.MIN_VALUE) return 0;
    if (n < 0) {
        n = -n;
        x = 1 / x;
    }
    double res = 1;
    while (n > 0) {
        if ((n & 1) == 1)  res *= x; // execude only when odd: n, 1; even: 1
        x *= x; // x to the power of 2
        n >>= 1; // divide the power by 2
    }
    return res;
}



