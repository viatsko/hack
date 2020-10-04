394. Decode String
// https://leetcode.com/problems/decode-string/

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

// digit: push into count stack, 
// letter: update res, 
// [: push res to res stack, 
// ]: pop out of res stack and append res count times

public String decodeString(String s) {
    StringBuilder res = new StringBuilder();
    Stack<StringBuilder> resStack = new Stack<>();
    Stack<Integer> countStack = new Stack<>();
    int i = 0;
    while (i < s.length()) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) {
            int count = 0;
            while (Character.isDigit(s.charAt(i))) 
                count = count * 10 + s.charAt(i++) - '0';
            countStack.push(count);
        } else if (c == '[') {
            resStack.push(new StringBuilder(res)); // important
            res.setLength(0);
            i++;
        } else if (c == ']') {
            StringBuilder tmp = resStack.pop();
            int count = countStack.pop();
            while (count-- > 0) 
                tmp.append(res.toString());
            res = tmp;
            i++;
        } else
            res.append(s.charAt(i++));
    }
    return res.toString();
}