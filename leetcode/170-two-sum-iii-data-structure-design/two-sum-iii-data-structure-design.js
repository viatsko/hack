/**
 * Initialize your data structure here.
 */
const TwoSum = function () {
  this.map = new Map();
};

/**
 * Add the number to an internal data structure..
 * @param {number} number
 * @return {void}
 */
TwoSum.prototype.add = function (number) {
  if (!this.map.has(number)) this.map.set(number, 1);
  else this.map.set(number, this.map.get(number) + 1);
};

/**
 * Find if there exists any pair of numbers which sum is equal to the value.
 * @param {number} value
 * @return {boolean}
 */
TwoSum.prototype.find = function (target) {
  for (const [key, value] of this.map.entries()) {
    if (target - key === key) {
      if (this.map.get(target - key) >= 2) {
        return true;
      }
    } else if (this.map.has(target - key)) {
      return true;
    }
  }

  return false;
};

/**
 * Your TwoSum object will be instantiated and called as such:
 * var obj = new TwoSum()
 * obj.add(number)
 * var param_2 = obj.find(value)
 */
