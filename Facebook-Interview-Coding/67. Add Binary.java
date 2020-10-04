67. Add Binary
// https://leetcode.com/problems/add-binary/

a = "11"
b = "1"
Return "100".

//if we need to calculate hexadecimal or k decimal, carry = sum / k; res.append(sum % k), and use hash to map 'ABCDEF' to nums
//if we have zeros at the front of strings, and we only need one MS bit,first clear all zeros at the front, after calculaing,
//add '0' if no overflow, add '1' if overflow (length >= 32 or carry == 1)
Solution 1:

public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int i = a.length() - 1, j = b.length() - 1;
    int sum = 0;
    while (i >= 0 || j >= 0) {
        sum /= 2;
        if (i >= 0)     sum += a.charAt(i--) - '0';
        if (j >= 0)     sum += b.charAt(j--) - '0';
        sb.append(sum % 2);
    }
    if (sum / 2 != 0)   sb.append(sum / 2);
    return sb.reverse().toString();
}


Solution 2: bit manipulation
// not using +-*/, only use bit manipulations

public String addBinary(String a, String b) {
    StringBuilder res = new StringBuilder();
    int i = a.length() - 1, j = b.length() - 1;
    int carry = 0;
    while (i >= 0 || j >= 0) {
        int num1 = i >= 0 ? Integer.valueOf(String.valueOf(a.charAt(i--))) : 0;
        int num2 = j >= 0 ? Integer.valueOf(String.valueOf(a.charAt(j--))) : 0;
        int sum = carry ^ num1 ^ num2;//curr digit
        carry = (num1 & num2) | (num1 & carry) | (num2 & carry);
        res.append(sum);//if don't use StringBuilder,we can use res=String.valueOf(sum%2)+res,then no need to reverse
    }
    if (carry == 1)    res.append(1);
    return res.reverse().toString();//append&reverse,instead of inserting at front cuz sb is array-based,insert will be
}


