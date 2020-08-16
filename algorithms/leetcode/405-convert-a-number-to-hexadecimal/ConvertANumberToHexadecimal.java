public class ConvertANumberToHexadecimal {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        long n = num & 0x00000000ffffffffL;

        char[] letters = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        StringBuilder result = new StringBuilder();

        while (n > 0) {
            result.insert(0, letters[(int) (n % 16)]);
            n = n / 16;
        }

        return result.toString();
    }
}
