public class SqrtX {
    public int mySqrt(int num) {
        long n = num;

        while(n * n > num) {
            n = (n + num / n) / 2;
        }

        return (int) n;
    }
}
