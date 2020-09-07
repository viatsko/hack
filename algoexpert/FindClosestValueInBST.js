function findClosestValueInBst(node, target) {
  const q = [node];

  let minDist = Number.MAX_SAFE_INTEGER;
  let minVal;

  while (q.length) {
    const curr = q.pop();
    if (curr.left) {
      q.push(curr.left);
    }
    if (curr.right) {
      q.push(curr.right);
    }
    if (minDist > Math.abs(target - curr.value)) {
      minDist = Math.abs(target - curr.value);
      minVal = curr.value;
    }
  }

  return minVal;
}

// This is the class of the input tree. Do not edit.
class BST {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

// Do not edit the line below.
exports.findClosestValueInBst = findClosestValueInBst;
