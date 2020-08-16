class Tree<T> {
  value: T;
  left: Tree<T>;
  right: Tree<T>;

  constructor(value: T) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}
