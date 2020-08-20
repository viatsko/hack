class Solution {
  public int primePalindrome(int N) {
    if (N <= 1) {
      return 2;
    }

    long min = N;

    int nDigits = (int)Math.floor(Math.log10(Math.abs(N))) + 1;

    // optimization = we know that there's no prime palindrome with even number of digits beside 11
    if (nDigits > 2 && nDigits % 2 == 0) {
      min = (long)Math.pow(10, nDigits);
    }

    long max = min * 100;

    for (long current = min; current < max; current++) {
      long x = current;
      long reversed = 0;

      // TODO break earlier here
      while(x > 0) {
        reversed = reversed * 10;
        reversed = reversed + x % 10;
        x = x / 10;
      }

      if (reversed == current) {
        int d = (int)Math.sqrt(current);

        int j;
        for (j = 2; j <= d; j++) {
          if (current % j == 0) {
            break;
          }
        }

        if (j == d + 1) {
          return (int) current;
        }
      }
    }

    return -1;
  }
}
