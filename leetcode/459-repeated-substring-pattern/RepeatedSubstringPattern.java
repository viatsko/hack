class Solution {
  public boolean repeatedSubstringPattern(String s) {
    /*
      abab + abab = abababab
                     substr 1 and -1
                     bababa
                      abab ^ contains

      aba + aba = abaaba
                   substr 1 and -1
                   baab
                    ^ doesn't contain aba as mid mismatched
    */
    return (s + s).substring(1, 2 * s.length() - 1).contains(s);
  }
}
