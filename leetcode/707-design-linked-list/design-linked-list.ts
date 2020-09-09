class Node {
  public value: number;
  public next: Node | null;
  public prev: Node | null;

  constructor(value: number) {
    this.value = value;
    this.next = null;
    this.prev = null;
  }
}

class MyLinkedList {
  private head: Node | null;
  private tail: Node | null;
  private size: number;

  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  isValid(index: number): boolean {
    return index >= 0 && index < this.size;
  }

  getNode(index: number): Node | null {
    let node: Node | null = this.head;
    while (node && index-- > 0) {
      node = node.next;
    }
    return node;
  }

  get(index: number): number {
    if (this.isValid(index)) {
      return this.getNode(index)!.value;
    } else {
      return -1;
    }
  }

  addAtHead(val: number): void {
    const node = new Node(val);

    if (this.head === null) {
      this.head = this.tail = node;
    } else {
      this.head.prev = node;
      node.next = this.head;
      this.head = node;
    }

    this.size++;
  }

  addAtTail(val: number): void {
    const node = new Node(val);

    if (this.head === null || this.tail === null) {
      this.head = this.tail = node;
    } else {
      this.tail.next = node;
      node.prev = this.tail;
      this.tail = node;
    }

    this.size++;
  }

  addAtIndex(index: number, val: number): void {
    if (index < 0 || index > this.size) {
      return;
    }

    if (index === 0) {
      this.addAtHead(val);
    } else if (index === this.size) {
      this.addAtTail(val);
    } else {
      const prev = this.getNode(index - 1)!;
      const next = this.getNode(index)!;

      const node = new Node(val);
      node.prev = prev;
      prev.next = node;
      node.next = next;
      next.prev = node;

      this.size++;
    }
  }

  deleteAtIndex(index: number): void {
    if (this.isValid(index)) {
      if (index === 0) {
        if (this.head === this.tail) {
          this.head = this.tail = null;
        } else {
          this.head = this.head!.next;
        }
      } else if (index === this.size - 1) {
        this.tail = this.tail!.prev;
      } else {
        const node = this.getNode(index);

        const prev = node!.prev;
        const next = node!.next;
        prev!.next = next;
        next!.prev = prev;
      }

      this.size--;
    }
  }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = new MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(val)
 * obj.addAtTail(val)
 * obj.addAtIndex(index,val)
 * obj.deleteAtIndex(index)
 */
