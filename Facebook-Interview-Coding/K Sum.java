K Sum

two sum with duplicate number返回所有的可能的index pairs，我用的是map<Integer, Set<Integer>>

public List<int[]> findNumbersThatSumToTarget(int[] arr, int target) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    List<int[]> res = new ArrayList<int[]>();
    for (int i = 0; i < arr.length; i++){
        if (!map.containsKey(arr[i]))
            map.put(arr[i], new HashSet<Integer>());
        map.get(arr[i]).add(i);
        if (map.containsKey(target - arr[i])){
            for(Integer j: map.get(target - arr[i]))
                if(j != i)    res.add(new int[]{i, j}); // notice: j != i
        }
    }
    return res;
}


15. 3sum
此题Follow K sum 可以用递归做，见最后

具体代码就是三个for循环，但是index 都是从0开始，所以会有重复 同 个数的问题。然后问我怎么fix这个bug, 就是把每个循环的起始index变成i+1，i是上 层循环的当前 index。
接下来就问我时间复杂度，有没有 优解。




// https://leetcode.com/problems/3sum/
For example, given array S = [-1, 0, 1, 2, -1, -4],
A solution set is:
[[-1, 0, 1],
[-1, -1, 2]]

注意先sort，和三次avoid duplicates的代码

Time: O(n^2)

public List<List<Integer>> threeSum(int[] nums) {
	List<List<Integer>> res = new ArrayList<>();
	Arrays.sort(nums);
	for (int i = 0; i < nums.length - 2; i++) {
		if (i > 0 && nums[i] == nums[i - 1]) 	continue;
		int left = i + 1, right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] == -nums[i]) {
				res.add(Arrays.asList(nums[i], nums[left], nums[right])); // important! see @ NOTICE
				while (left < right && nums[left] == nums[left + 1])	left++;
				while (left < right && nums[right] == nums[right - 1])	right--;
				left++;
				right--;
			} else if (nums[left] + nums[right] < -nums[i]) {
				while (left < right && nums[left] == nums[left + 1])	left++;
				left++;
			} else {
				while (left < right && nums[right] == nums[right - 1])	right--;
				right--;
			}
		}
	}
	return res;
}

NOTICE:
注意参数是Arrays.asList(nums[i], nums[left], nums[right])，不能写作Arrays.asList(new int[]{nums[i], nums[left], nums[right]})！
Arrays的asList方法
JDK 1.4对java.util.Arrays.asList的定义，函数参数是Object[]。所以，在1.4中asList()并不支持基本类型的数组作参数。
JDK 1.5中，java.util.Arrays.asList的定义，函数参数是Varargs, 采用了泛型实现。同时由于autoboxing的支持，使得可以支持对象数组以及基本类型数组。
不过在使用时，当传入基本数据类型的数组时，会出现小问题，会把传入的数组整个当作返回的List中的第一个元素。
// 所以此题如果用Arrays.asList(new int[]{i, left, right})，LC 的报错是“error: no suitable method found for add(List<int[]>)”，
// 也就是说编译器把int[]当作参数类型了，而我们真正想要的参数类型是int。印证了上述解释。


Follow Up: K Sum
e.x. 4 sum
其实我们可以考虑用二分法的思路，如果把所有的两两pair都求出来，然后再进行一次Two Sum的匹配，我们知道Two Sum是一个排序加上一个线性的操作，
并且把所有pair的数量是O((n-1)+(n-2)+...+1)=O(n(n-1)/2)=O(n^2)。所以对O(n^2)的排序如果不用特殊线性排序算法是O(n^2*log(n^2))=O(n^2*2logn)=O(n^2*logn)，
算法复杂度比上一个方法的O(n^3)是有提高的。思路虽然明确，不过细节上会多很多情况要处理。
首先，我们要对每一个pair建一个数据结构来存储元素的值和对应的index，这样做是为了后面当找到合适的两对pair相加能得到target值时看看他们是否有重叠的index，
如果有说明它们不是合法的一个结果，因为不是四个不同的元素。接下来我们还得对这些pair进行排序，所以要给pair定义comparable的函数。
最后，当进行Two Sum的匹配时因为pair不再是一个值，所以不能像Two Sum中那样直接跳过相同的，每一组都得进行查看，这样就会出现重复的情况，
所以我们还得给每一个四个元素组成的tuple定义hashcode和相等函数，以便可以把当前求得的结果放在一个HashSet里面，这样得到新结果如果是重复的就不加入结果集了。


另附DP的 k-sum：// http://www.cnblogs.com/yuzhangcmu/p/4279676.html
















