161. One Edit Distance
// https://leetcode.com/problems/one-edit-distance/


Tests: 1.replace one char, 2.delete one char in s, 3.delete one char in t
corner cases: "" (len = 0)

public boolean isOneEditDistance(String s, String t) {
    int len = Math.min(s.length(), t.length());
    for (int i = 0; i < len; i++) {
        if (s.charAt(i) != t.charAt(i)) {
            if (s.length() == t.length())   return s.substring(i + 1).equals(t.substring(i + 1)); // replace
            else if (s.length() < t.length())   return s.substring(i).equals(t.substring(i + 1)); // delete t
            else    return s.substring(i + 1).equals(t.substring(i)); // delete s
        }
    }
    return Math.abs(s.length() - t.length()) == 1; // corner case: ""
}

原题 但是不能用substring ====>>>   要一个字符一个字符比较