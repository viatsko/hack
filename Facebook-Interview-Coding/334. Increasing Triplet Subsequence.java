334. Increasing Triplet Subsequence
// https://leetcode.com/problems/increasing-triplet-subsequence/

Given [1, 2, 3, 4, 5],
return true.
Given [5, 4, 3, 2, 1],
return false.

问怎么test code，要求考虑corner cases。


public boolean increasingTriplet(int[] nums) {
    int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
    for(int num : nums){
        if(num <= min)      min = num; // important
        else if(num <= secondMin)    secondMin = num;// important
        else    return true;
    }
    return false;
}

