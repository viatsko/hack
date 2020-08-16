class Solution {
    public int minAddToMakeValid(String S) {
        int unclosedLeft = 0;
        int unclosedRight = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                unclosedRight++;
            } else if (unclosedRight > 0) {
                unclosedRight--;
            } else {
                unclosedLeft++;
            }
        }
        return unclosedLeft + unclosedRight;
    }
}
