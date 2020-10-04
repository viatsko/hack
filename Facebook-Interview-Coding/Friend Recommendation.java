Friend Recommendation
return friends of friends that are not this persons friends
// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=210056&extra=page%3D3%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

思路：第二层的friends排序，选出k个共同好友做多的friends


Solution 1: Bucket Sort
Time: O(m)  Space: O(n)
// m: # of person's friends' friends, n: # of legal recommend friends

public class Person {
    int id;
    HashSet<Integer> friends = new HashSet<>();
}
private List<Integer> friendsRecommend(Person person, int k) {
    List<Integer> res = new ArrayList<>();
    if (person == null)    return res;
    Map<Integer, Integer> map = new HashMap<>(); // recommend id -> count
    int b = 0;
    for (int friend : person.friends) 
        for (int recommend : friend.friends) {
           int id = recommend.id;
           if (person.friends.contains(id) || id == person.id) // don't forget 'id == person.id'
               continue;
           map.put(id, map.getOrDefault(id, 0) + 1);
           b = Math.max(b, map.get(id));
       }
    // bucket sort 'recommend list'
    List<Integer>[] buckets = new List[b];
    for (int id : map.keySet()) { 
        if (buckets[map.get(id)] == null)
            buckets[map.get(id)] = new ArrayList<Integer>();
        buckets[map.get(id)].add(id);
    }
    //this two loops are O(k) time, when res has k nums, return it
    for (int i = b; i >= 0; i--) 
        for (int j = 0; j < buckets[i].size(); j++) { 
            res.add(buckets[i].get(j));
            if (res.size() == k)    return res;
        }
    return res;
}


Solution 2: Quick Select
Time: average O(m), O(m + n^2) worst case 
Space: O(1) space
// m: # of person's friends' friends, n: # of legal recommend friends
public class Person {
    int id;
    HashSet<Integer> friends = new HashSet<>();
}
private List<Integer> friendsRecommend(Person person, int k) {
    List<Integer> res = new ArrayList<>();
    if (person == null)    return res;
    Map<Integer, Integer> map = new HashMap<>();
    // O(m)
    for (int friend : person.friends) 
        for (int recommend : friend.friends) {
           int id = recommend.id;
           if (person.friends.contains(id) || id == person.id)    continue;
           map.put(id, map.getOrDefault(id, 0) + 1);
       }
    // O(n) average, O(n^2) worst case
    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet()); // important
    int left = 0, right = list.size() - 1, pos = -1;
    while (true) {
        pos = partition(list, left, right);
        if (pos == k - 1) {
            index = pos;
            break;
        } else if (pos > k - 1)   right = pos - 1;
        else    left = pos + 1;
    }
    if (pos == -1)    return res;
    for (int i = 0; i <= pos; i++) {
        int id = list.get(i).getKey();
        res.add(id);
    }
    return res;
}
private int partition(List<Map.Entry<Integer, Integer>> list, int left, int right) {
    shuffle(list);
    int idx = left;//remember to add + left !!!
    Map.Entry<Integer, Integer> pivot = list.get(idx);
    int pVal = pivot.getValue();
    swap(list, right, idx);
    for (int i = left; i < right; i++) 
        if (list.get(i).getValue() > pVal)  swap(list, i, idx++);
    swap(list, right, idx);
    return idx;
}
private void swap(List<Map.Entry<Integer, Integer>> list, int left, int right) {
    Map.Entry<Integer, Integer> temp = list.get(left);
    list.set(left, list.get(right));
    list.set(right, temp);
}
private void shuffle(List<Map.Entry<Integer, Integer>> list) {
    final Random random = new Random();
    for(int ind = 1; ind < list.size(); ind++) {
        final int r = random.nextInt(ind + 1);
        swap(a, ind, r);
    }
}


简单版：mutual friends
已知一个function可以return 给定某人的friends。 找出A B的mutual friends:

用hashset













