const BUCKETS_SIZE = 769;

/**
 * Initialize your data structure here.
 */
const MyHashMap = function () {
  this.arr = [];
};

/**
 * value will always be non-negative.
 * @param {number} key
 * @param {number} value
 * @return {void}
 */
MyHashMap.prototype.put = function (key, value) {
  const bucket = key % BUCKETS_SIZE;

  if (!Array.isArray(this.arr)) this.arr = [];

  const el = this.arr.find((el) => el.key === key);

  if (el) {
    el.value = value;
  } else {
    this.arr.push({
      key,
      value,
    });
  }
};

/**
 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function (key) {
  const bucket = key % BUCKETS_SIZE;

  if (!Array.isArray(this.arr)) this.arr = [];

  const el = this.arr.find((el) => el.key === key);

  if (el) {
    return el.value;
  } else {
    return -1;
  }
};

/**
 * Removes the mapping of the specified value key if this map contains a mapping for the key
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function (key) {
  const bucket = key % BUCKETS_SIZE;

  if (!Array.isArray(this.arr)) this.arr = [];

  const elIdx = this.arr.findIndex((el) => el.key === key);
  if (elIdx !== -1) {
    this.arr.splice(elIdx, 1);
  }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */
