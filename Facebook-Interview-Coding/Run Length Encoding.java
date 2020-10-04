Run Length Encoding
Given an input string, write a function that returns the Run Length Encoded string for the input string.

For example, if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6”.

time: O(n)

public String runLength(String s){
    if(s == null || s.length() == 0)    return "";
    StringBuilder sb = new StringBuilder();
    int count = 1;
    for (int i = 0; i < s.length(); i++) {
        while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
            count++;
            i++;
        }  
        sb.append(s.charAt(i)).append(count);
        count = 1;
    }
    return sb.toString();
}
