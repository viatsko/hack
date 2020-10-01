const RecentCounter = function () {
  this.q = [];
};

/**
 * @param {number} t
 * @return {number}
 */
RecentCounter.prototype.ping = function (t) {
  const startRange = t - 3000;
  while (this.q.length && this.q[0] < startRange) {
    this.q.shift();
  }
  this.q.push(t);
  return this.q.length;
};

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = new RecentCounter()
 * var param_1 = obj.ping(t)
 */
