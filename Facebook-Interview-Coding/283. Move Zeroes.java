283. Move Zeroes

public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) return;        
    int idx = 0;
    for (int num: nums) 
        if (num != 0) 	nums[idx++] = num;
    while (idx < nums.length) 
        nums[idx++] = 0;
}

代码只需要返回最后有效数组的长度，有效长度之外的数字是什么无所谓，原先input里面的数字不一定要保持原来的相对顺序。
1.不用保持非零元素的相对顺序
2.不用把0移到右边
思路：把右边的非0元素移动到左边的0元素位置。这样就可以minimize writes.

public int moveZeroesWithMinWrites(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
        while (left < right && nums[left] != 0)		left++;
        while (left < right && nums[right] == 0)	right--;
        if (left < right)	nums[left++] = nums[right--];
    }
    return left;
}


