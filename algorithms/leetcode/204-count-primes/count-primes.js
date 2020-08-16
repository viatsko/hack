
// Method - https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
const countPrimes = n => {
    const prime = new Array(n).fill(true);

    prime[0] = false;
    prime[1] = false;

    for (let i = 2; i < Math.sqrt(n); i++) {
        if (prime[i]) {
            for (let j = Math.pow(i, 2); j < n; j += i) {
                prime[j] = false;
            }
        }
    }

    let cnt = 0;

    for (let i = 0; i < n; i++) {
        if (prime[i]) cnt++;
    }

    return cnt;
}
