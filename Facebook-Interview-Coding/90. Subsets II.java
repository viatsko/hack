90. Subsets II
// https://leetcode.com/problems/subsets-ii/
If nums = [1,2,2], a solution is:
[ [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []]

public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    dfs(res, new ArrayList<>(), nums, 0);
    return res;
}
public void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start) {
    res.add(new ArrayList<>(tmp));
    for (int i = start; i < nums.length; i++) {
        if (i > start && nums[i] == nums[i - 1])    continue;
        tmp.add(nums[i]);
        dfs(res, tmp, nums, i + 1);
        tmp.remove(tmp.size() - 1);
    }
}

非递归：
// 1,2,2,3
// res = (),| (1),| (2),(1,2),| (2,2),(1,2,2),| (3),(1,3),(2,3),(2,2,3),(1,2,2,3)
public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    res.add(new ArrayList<>());
    int size = 0, start = 0;
    for (int i = 0; i < nums.length; i++) { // num to insert
        start = (i != 0 && nums[i] == nums[i - 1]) ? size : 0; // prev res size
        size = res.size(); // cur res size
        for (int j = start; j < size; j++) { // set to be inserted into
            List<Integer> tmp = new ArrayList<>(res.get(j)); // important!
            tmp.add(nums[i]);
            res.add(tmp);
        }
    }
    return res;
}

follow up 
有个class，有个方法next(), 每次调用next()输出subsets中的下一个


