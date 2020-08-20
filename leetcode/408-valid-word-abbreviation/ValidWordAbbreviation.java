public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i, j;

        for (i = 0, j = 0; i < word.length() && j < abbr.length();) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else {
                char ch = abbr.charAt(j);

                // no letter match = bailing out in case of we don't have numbers
                if (ch <= '0' || ch > '9') { // 01 is not valid starting sequence
                    return false;
                }

                int numberStartIndex = j;

                while(j < abbr.length() && (abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9')) {
                    j++;
                }

                i += Integer.valueOf(abbr.substring(numberStartIndex, j));
            }
        }

        return i == word.length() && j == abbr.length();
    }
}
