/**
 Do not return anything, modify nums1 in-place instead.
 */
function merge(nums1: number[], m: number, nums2: number[], n: number): void {
  while (n > 0) {
    nums1[m + n - 1] =
      m === 0 || nums2[n - 1] > nums1[m - 1] ? nums2[n-- - 1] : nums1[m-- - 1];
  }
}
