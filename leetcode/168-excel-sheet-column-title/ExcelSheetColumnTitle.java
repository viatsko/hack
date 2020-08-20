public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        int base = 'A' - 1;

        while (n > 0) {
            char letter = (char) (base + n % 26);

            result.append(letter);

            n = n / 26;
        }

        return result.reverse().toString();
    }
}
