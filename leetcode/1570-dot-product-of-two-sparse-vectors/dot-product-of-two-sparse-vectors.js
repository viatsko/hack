/**
 * @param {number[]} nums
 * @return {SparseVector}
 */
var SparseVector = function (nums) {
  this.hash = {};

  for (let i = 0; i < nums.length; i++) {
    this.hash[i] = nums[i];
  }
};

// Return the dotProduct of two sparse vectors
/**
 * @param {SparseVector} vec
 * @return {number}
 */
SparseVector.prototype.dotProduct = function (vec) {
  let res = 0;

  for (const index in vec.hash) {
    if (this.hash[index]) {
      res += this.hash[index] * vec.hash[index];
    }
  }

  return res;
};

// Your SparseVector object will be instantiated and called as such:
// let v1 = new SparseVector(nums1);
// let v2 = new SparseVector(nums2);
// let ans = v1.dotProduct(v2);
