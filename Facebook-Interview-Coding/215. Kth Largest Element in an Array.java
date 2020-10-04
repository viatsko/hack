215. Kth Largest Element in an Array
// https://leetcode.com/problems/kth-largest-element-in-an-array/

Given [3,2,1,5,6,4] and k = 2, return 5.
先讨论 heap和 quick select的解法和复杂度 实现 quickselect的解法

Solution 1: Quick Select

Time: O(n) average, the problem is reduced to approximately half of its original size, giving the recursion T(n) = T(n/2) + O(n) 
	  O(n^2) worst case, the recursion may become T(n) = T(n - 1) + O(n)
// In the average sense, the problem is reduced to approximately half of its original size, giving the recursion T(n) = T(n/2) + O(n) 
// in which O(n) is the time for partition. This recursion, once solved, gives T(n) = O(n) and thus we have a linear time solution.
// Note that since we only need to consider one half of the array, the time complexity is O(n). 
// If we need to consider both the two halves of the array, like quicksort, then the recursion will be T(n) = 2T(n/2) + O(n) and the complexity will be O(nlogn).
// Of course, O(n) is the average time complexity. In the worst case, the recursion may become T(n) = T(n - 1) + O(n) and the complexity will be O(n^2).

public int findKthLargest(int[] nums, int k) {
	int left = 0, right = nums.length - 1;
	while (true) { // this problem guaranteed to have a valid answer
		int pos = partition(nums, left, right);
		if (pos == k - 1)	return nums[pos];
		else if (pos < k - 1)	left = pos + 1;
		else	right = pos - 1;
	}
}
private int partition(int[] nums, int left, int right) {
	shuffle(nums);
	int pivot = nums[left], idx = left;
	swap(nums, idx, right);
	for (int i = left; i < right; i++) 
		if (nums[i] > pivot)	swap(nums, i, idx++);
	swap(nums, idx, right);
	return idx;
}
private void swap(int[] nums, int i, int j) {
	int tmp = nums[i];
	nums[i] = nums[j];
	nums[j] = tmp;
}
private void shuffle(int a[]) {
    final Random random = new Random();
    for(int ind = 1; ind < a.length; ind++) {
        final int r = random.nextInt(ind + 1);
        swap(a, ind, r);
    }
}


Solution 2: PQ

Time: O(nlogk)

public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int n : nums) {
        pq.offer(n);
        if (pq.size() > k)  pq.poll();
    }
    return pq.peek();
}