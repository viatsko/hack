function hasPathWithGivenSum(root: Tree<number>, sum: number): boolean {
  if (!root && sum === 0) {
    return true;
  }

  function traverse(node: Tree<number>, currentSum: number): boolean {
    if (!node) {
      return false;
    }

    if (!node.left && !node.right && (currentSum + node.value) === sum) {
      return true;
    }

    return traverse(node.left, currentSum + node.value) || traverse(node.right, currentSum + node.value);
  }

  return traverse(root, 0);
}
