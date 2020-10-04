139. Word Break
// https://leetcode.com/problems/word-break/

public boolean wordBreak(String s, Set<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i < dp.length; i++)
        for (int j = 0; j < i; j++) 
            if (dp[j] && wordDict.contains(s.substring(j, i))) {
                dp[i] = true;
                break;
            }
    return dp[s.length()];
}

给一个字符串 such as: "GoogleFacebookMicrosoft", 由字母构成，然后给一个字典，把给定的字符按照字典进行切割，然后输出分割后的一个解答，
例如：dict=['Google', 'Facebook', 'Microsoft', 'GoogleFace', 'bookMicsoft']
如果有多个解答，输出一个即可，对于这个例子显然有两个解答，"Google Facebook Microsoft"， "GoogleFace bookMicrosoft"。随便输出一个就行
我回答，递归可以做，然后给出了答案，分析了复杂度O(n^m)。这里复杂度分析卡了一下，不过还好

followup，有没有其他方法可以做？我说可以DP做，f[i] = True意味着0～i-1存在 matching，为了输出一个solution，用g[i+len(w)] = i记录结果，然后回溯方法可以输出一个答案。interviewer跑了个conner case比较满意。
// http://www.1point3acres.com/bbs/forum.php?mod=redirect&goto=findpost&ptid=207049&pid=2597080&fromuid=96813

public String wordBreak(String s, Set<String> dict) {
    if (s.length() == 0 || dict.size() == 0)    return true;
    int maxLength = getMaxLength(dict);
    boolean[] dp = new boolean[s.length() + 1];//dp[i]:whether 0 to i part of string can be segmented into words in dict
    int[] words = new int[s.length() + 1];//words[i]:index of the end of a dict's word s.substr(i,words[i])
    dp[0] = true;
    words[0] = -1;
    for (int i = 1; i <= s.length(); i++) //O(n) * O(maxLength)
        for (int lastWordLength = 1; lastWordLength <= maxLength && lastWordLength <= i; lastWordLength++) //<= i !!!
            if (dp[i - lastWordLength] && dict.contains(s.substring(i - lastWordLength, i))) {//need add s.substring !!!
                dp[i] = true;//if string from 0 to i-lastWordLength is segmentable, and i-lastWordLength to i is in dict
                words[i - lastWordLength] = i;//record the index of breaking position
                break;//eg. 0 L E E T C O D E -> L(F),i++ -> E(F),LE(F),i++ -> E(F),EE(F),LEE(F),i++ -> .....,LEET(T)
            }         //    T F F F T F F F T
    //remember to check dp[s.length()] first !!!
    if (!dp[s.length()])     return "";
    StringBuilder sb = new StringBuilder(s.substring(0, words[0]));
    int start = words[0];
    while (start != s.length()) {
        sb.append(" " + s.substring(start, words[start]));
        start = words[start];//remember to update start !!!
    }
    return sb.toString();
}
private int getMaxLength(Set<String> dict) {
    int max = 0;
    for (String s : dict) 
        max = Math.max(max, s.length());
    return max;
}



------------------------------------------
140. Word Break II
// https://leetcode.com/problems/word-break-ii/

Solution 1: DP + DFS
Time: O(n * m) + O(n * # of solutions), 
//where n is the length of the input string, m is the length of the longest word in the dictionary.

public List<String> wordBreak(String s, List<String> wordDict) {
    List<Integer>[] startPos = new List[s.length() + 1]; // all valid start pos for each valid end pos
    startPos[0] = new ArrayList<>();
    int maxLen = 0;
    for (String w : wordDict) 
        maxLen = Math.max(maxLen, w.length());
    for (int i = 1; i <= s.length(); i++) 
        for (int j = i - 1; j >= Math.max(0, i - maxLen); j--) {
            if (startPos[j] == null)    continue;
            String word = s.substring(j, i);
            if (wordDict.contains(word)) {
                if (startPos[i] == null)    startPos[i] = new ArrayList<>();
                startPos[i].add(j);
            }
        }
    List<String> res = new ArrayList<>();
    if (startPos[s.length()] == null)   return res;
    dfs(res, "", s.length(), s, startPos);
    return res;
}
private void dfs(List<String> res, String tmp, int end, String s, List<Integer>[] startPos) {
    if (end == 0) {
        res.add(tmp.substring(1));
        return;
    }
    for (Integer start : startPos[end]) {
        String w = s.substring(start, end);
        dfs(res, " " + w + tmp, start, s, startPos);
    }
}


Solution 2: DFS + memoization

Map<String,List<String>> map = new HashMap<String,List<String>>();
public List<String> wordBreak(String s, Set<String> wordDict) {
    List<String> res = new ArrayList<String>();
    if (s == null || s.length() == 0)    return res;
    if (map.containsKey(s))     return map.get(s);
    if (wordDict.contains(s))    res.add(s); // important
    for (int i = 1 ; i < s.length() ; i++) {
        String t = s.substring(i);
        if (wordDict.contains(t)) {
            List<String> temp = wordBreak(s.substring(0 , i) , wordDict);
            if (temp.size() != 0) 
                for(int j = 0 ; j < temp.size() ; j++) 
                    res.add(temp.get(j) + " " + t);
        }
    }
    map.put(s , res);
    return res;
}


normal DFS -> 'TLE'
Time: O(2 ^ n) //http://www.1point3acres.com/bbs/forum.php?mod=redirect&goto=findpost&ptid=117602&pid=1699371&fromuid=96813

public List<String> wordBreak(String s, List<String> wordDict) {
    List<String> res = new ArrayList<>();
    dfs(res, new StringBuilder(), 0, s, wordDict);
    return res;
}
private void dfs(List<String> res, StringBuilder sb, int start, String s, List<String> wordDict) {
    if (start == s.length()) {
        res.add(sb.substring(1));
        return;
    }
    for (int i = start; i < s.length(); i++) {
        int len = sb.length();
        if (wordDict.contains(s.substring(start, i + 1)))
            dfs(res, sb.append(" ").append(s.substring(start, i + 1)), i + 1, s, wordDict);
        sb.setLength(len);
    }
}





