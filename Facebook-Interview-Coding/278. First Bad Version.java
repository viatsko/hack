278. First Bad Version
// https://leetcode.com/problems/first-bad-version/

public int firstBadVersion(int n) {
    int left = 1, right = n;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (isBadVersion(mid))  right = mid;
        else    left = mid + 1;
    }
    return left;
}