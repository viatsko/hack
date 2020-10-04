380. Insert Delete GetRandom O(1)

public class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> nums;
    Random random;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))     return false;
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) 	return false;
        int pos = map.get(val);
        if (pos < map.size() - 1) {
            map.put(nums.get(nums.size() - 1), pos);
            nums.set(pos, nums.get(nums.size() - 1));
        }
        map.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}
