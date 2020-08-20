public class StringCompression {
    public int compress(char[] chars) {
        int n = chars.length;

        int j = 0;

        for (int i = 0; i < n; i++) {
            chars[j++] = chars[i];

            int count = 1;

            while ((i < n - 1) && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }

            if (count == 1) {
                continue;
            }

            char[] num = String.valueOf(count).toCharArray();

            for (char aNum : num) {
                chars[j++] = aNum;
            }
        }

        return j;
    }
}
