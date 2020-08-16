class Solution {
public:
  int countPrimes(int n) {
    bool primes[n + 1];
    memset(primes, true, sizeof(primes));
    
    for (int i = 2; i * i <= n; i++) {
      if (primes[i]) {
        for (int j = i * i; j <= n; j += i) {
          primes[j] = false;
        }
      }
    }
    
    int answer = 0;
    for (int i = 2; i < n; i++) {
      if (primes[i]) {
        answer++;
      }
    }
    return answer;
  }
};
