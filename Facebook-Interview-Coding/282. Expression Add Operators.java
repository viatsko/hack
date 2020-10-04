282. Expression Add Operators
此题简单版见最后
// https://leetcode.com/problems/expression-add-operators/
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []

Test:
- edge cases:
// overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
// 0 sequence: because we cannot have numbers with multiple digits started with zero, we have to deal with it too.
"105", 5 -> ["1*0+5","10-5"] //0 sequence
"00", 0 -> ["0+0", "0-0", "0*0"] //0 sequence
"3456237490", 9191 -> [] // no answer
"232", 8 -> ["2*3+2", "2+3*2"]
// a little trick is that we should save the value that is to be multiplied in the next recursion.
// for example, if you have a sequence of 12345 and you have proceeded to 1 + 2 + 3, now your eval is 6 right? 
// If you want to add a * between 3 and 4, you would take 3 as the digit to be multiplied, so you want to take it out from the existing eval. 
// You have 1 + 2 + 3 * 4 and the eval now is (1 + 2 + 3) - 3 + (3 * 4). 

Time: O(n * 4^n) ???
// Each digit have 4 situations(+,-,*,none)下面分析不对
// T(n) = 3 * T(n-1) + 3 * T(n-2) + 3 * T(n-3) + ... + 3 *T(1);
// T(n-1) = 3 * T(n-2) + 3 * T(n-3) + ... 3 * T(1);
// Thus T(n) = 4T(n-1);

public List<String> addOperators(String num, int target) {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    dfs(res, sb, num, target, 0, 0, 0);
    return res;
}
private void dfs(List<String> res, StringBuilder sb, String nums, int target, int start, long eval, long mult) {
    if (start == nums.length()) {
        if (eval == target)     res.add(sb.toString());
        return;
    }
    // dfs call on all numbers starting at position 'start'
    for (int i = start; i < nums.length(); i++) {
        if (nums.charAt(start) == '0' && i != start)    break; // '0' cannot be leading number, so stop further dfs
        long cur = Long.valueOf(nums.substring(start, i + 1));
        int len = sb.length();
        if (start == 0)
            dfs(res, sb.append(cur), nums, target, i + 1, eval + cur, cur);
        else {
            dfs(res, sb.append("+").append(cur), nums, target, i + 1, eval + cur, cur);
            sb.setLength(len);
            dfs(res, sb.append("-").append(cur), nums, target, i + 1, eval - cur, -cur);
            sb.setLength(len);
            dfs(res, sb.append("*").append(cur), nums, target, i + 1, eval - mult + mult * cur, mult * cur);
        }
        sb.setLength(len);
    }
}           

[StringBuilder V.S. String]
// http://blog.csdn.net/shfqbluestone/article/details/34188325




*******简单版*******
给1个string “123456789”， 进行arithmetic oepration combination.  
如: 123 + 456 + 78 -9 是1种组合， -1 + 2 -3 +4 -5 - 67 + 89 也是1种(只加 + 或 -), 打印出所有结果等于 100 的组合

Test:
"1234567" -> ["1+2+34+56+7", "1+23+4+5+67"]

public List<String> addOperators(String num, int target) {
    List<String> res = new ArrayList<>();
    dfs(res, "", num, target, 0, 0);
    return res;
}
private void dfs(List<String> res, String tmp, String nums, int target, int start, long eval) {
    if (start == nums.length()) {
        if (eval == target)     res.add(tmp);
        return;
    }
    // dfs call on all numbers starting at position 'start'
    for (int i = start; i < nums.length(); i++) {
        if (nums.charAt(start) == '0' && i != start)    break; // '0' cannot be leading number, so stop further dfs
        long cur = Long.valueOf(nums.substring(start, i + 1));
        if (start == 0)
            dfs(res, tmp + cur, nums, target, i + 1, eval + cur);
        else {
            dfs(res, tmp + "+" + cur, nums, target, i + 1, eval + cur);
            dfs(res, tmp + "-" + cur, nums, target, i + 1, eval - cur);
        }
    }
} 






