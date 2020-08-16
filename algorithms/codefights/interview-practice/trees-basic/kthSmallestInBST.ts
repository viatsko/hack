function kthSmallestInBST(root: Tree<number>, k: number): number {
  let node: Tree<number> = root;

  const stack: Tree<number>[] = [];

  while(node || stack.length) {
      if (node) {
          stack.push(node);
          node = node.left;
      } else {
          node = stack.pop();
          if (--k === 0) {
              return node.value;
          }
          node = node.right;
      }
  }

  return Number.MIN_SAFE_INTEGER;
}
