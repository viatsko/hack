Most Frequenct Character in a String


hashmap存频率，然后维持count最大的
public char findMostFrequent(String s) {
    Map<Character,Integer> map=new HashMap<>();
    int count = 0;
    char res = '';
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        Character.toLowerCase(c); // 不区分大小写
        if (!Character.isLetterOrDigit(c)) 	continue; // 去掉其他字符
        if (c == ' ') 	continue; //去掉空格加这个
        map.put(c, map.getOrDefault(c, 0)+1);
        if (map.get(c) > count) {
            count = map.get(c);
            res = c;
        }
    }
    return res;
}


Follow Up:
优化时间，count维持两个，频率第一大，第二大，1-2如果>=剩下的，就可以了。

public char findMostFrequent(String s) {
    Map<Character,Integer> map=new HashMap<>();
    int count1 = 0, count2 = 0;
    char c1 = '';//, c2 = '';
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (!Character.isLetterOrDigit(c)) 	continue;
        map.put(c, map.getOrDefault(c, 0)+1);
        if (map.get(c) >= count1) {
            count2 = count1;
            //c2 = c1;
            count1 = map.get(c);
            c1 = c;
        } else if(map.get(c) >= count2){
            count2 = map.get(c);
            //c2 = c;
        }
        if (count1 - count2 >= s.length() - i) 
            return c1;
    }
    return c1;
}









