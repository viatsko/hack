class Node {
  constructor(val) {
    this.val = val;
    this.next = null;
    this.prev = null;
  }
}

/**
 * Initialize your data structure here.
 */
var MyLinkedList = function () {
  this.head = null;
  this.tail = null;
  this.capacity = 0;
};

MyLinkedList.prototype.isValidIndex = function (index) {
  return Boolean(index >= 0 && index < this.capacity);
};

MyLinkedList.prototype.getNode = function (index) {
  if (!this.isValidIndex) {
    return null;
  }

  let node = this.head;
  for (let i = 0; i < index; i++) {
    node = node.next;
  }
  return node;
};

/**
 * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 * @param {number} index
 * @return {number}
 */
MyLinkedList.prototype.get = function (index) {
  const node = this.getNode(index);

  if (!node) {
    return -1;
  } else {
    return node.val;
  }
};

/**
 * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtHead = function (val) {
  const node = new Node(val);

  if (this.capacity === 0) {
    this.head = this.tail = node;
  } else {
    node.next = this.head;
    this.head.prev = node;
    this.head = node;
  }

  this.capacity++;
};

/**
 * Append a node of value val to the last element of the linked list.
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtTail = function (val) {
  const node = new Node(val);

  if (this.capacity === 0) {
    this.head = this.tail = node;
  } else {
    node.prev = this.tail;
    this.tail.next = node;
    this.tail = node;
  }

  this.capacity++;
};

/**
 * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
 * @param {number} index
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtIndex = function (index, val) {
  if (index === 0) {
    this.addAtHead(val);
  } else if (index === this.capacity) {
    this.addAtTail(val);
  } else {
    const next = this.getNode(index);

    if (!next) {
      return;
    }

    const prev = next.prev;

    const node = new Node(val);

    prev.next = node;
    node.prev = prev;
    next.prev = node;
    node.next = next;

    this.capacity++;
  }
};

/**
 * Delete the index-th node in the linked list, if the index is valid.
 * @param {number} index
 * @return {void}
 */
MyLinkedList.prototype.deleteAtIndex = function (index) {
  const node = this.getNode(index);

  if (!node) {
    return;
  }

  /* delete head */
  if (index === 0) {
    /* delete head and tail if capacity === 1 */
    if (this.capacity === 1) {
      this.head = this.tail = null;
    } else {
      this.head.next.prev = null;
      this.head = this.head.next;
    }
    /* delete tail */
  } else if (index === this.capacity - 1) {
    this.tail.prev.next = null;
    this.tail = this.tail.prev;
  } else {
    const prev = node.prev;
    const next = node.next;

    prev.next = next;
    next.prev = prev;
  }

  this.capacity--;
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = new MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(val)
 * obj.addAtTail(val)
 * obj.addAtIndex(index,val)
 * obj.deleteAtIndex(index)
 */
