const BUCKETS_SIZE = 769;

/**
 * Initialize your data structure here.
 */
const MyHashSet = function () {
  this.arr = [];
};

/**
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.add = function (key) {
  const bucket = key % BUCKETS_SIZE;
  if (!this.arr[bucket]) {
    this.arr[bucket] = [];
  }

  if (this.arr[bucket].indexOf(key) === -1) {
    this.arr[bucket].push(key);
  }
};

/**
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.remove = function (key) {
  const bucket = key % BUCKETS_SIZE;

  if (!Array.isArray(this.arr[bucket])) return;

  const keyIndex = this.arr[bucket].indexOf(key);

  if (keyIndex !== -1) {
    this.arr[bucket].splice(keyIndex, 1);
  }
};

/**
 * Returns true if this set contains the specified element
 * @param {number} key
 * @return {boolean}
 */
MyHashSet.prototype.contains = function (key) {
  const bucket = key % BUCKETS_SIZE;

  if (!Array.isArray(this.arr[bucket])) return false;

  return this.arr[bucket].indexOf(key) !== -1;
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */
