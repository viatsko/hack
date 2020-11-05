class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int j = 0;
        while (j < s.length()) {
            for (int i = 0; i < numRows && j < s.length(); i++) {
                rows[i].append(s.charAt(j));
                j++;
            }

            for (int i = numRows - 2; i >= 1 && j < s.length(); i--) {
                rows[i].append(s.charAt(j));
                j++;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(rows[i]);
        }

        return result.toString();
    }
}
