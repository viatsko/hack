function isTreeSymmetric(root: Tree<number>): boolean {
  if (!root) {
    return true;
  }

  function traverse(left, right): boolean {
    if (!left && !right) {
      return true;
    }

    if (
      left &&
      right &&
      left.value === right.value &&
      traverse(left.left, right.right) &&
      traverse(left.right, right.left)
    ) {
      return true;
    }

    return false;
  }

  return traverse(root.left, root.right);
}
