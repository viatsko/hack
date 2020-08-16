class Solution {
    public int scoreOfParentheses(String s) {
        int result = 0;
        int level = 1;

        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                level++;
            } else {
                level--;

                if (prev == '(') {
                    result += (1 << level);
                }
            }

            prev = c;
        }

        return result;
    }
}
