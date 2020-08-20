from random import randint


class Node:
    def __init__(self, data=None, next=None):
        self.data = data
        self.next = next


class LinkedList:
    def __init__(self, head=None):
        self.head = head

    def insert(self, data):
        node = Node(data)
        node.next = self.head
        self.head = node

    def generate(self, length, minimum, maximum):
        for _ in range(length):
            self.insert(randint(minimum, maximum))

    def __str__(self):
        out = []

        current = self.head

        while current.next:
            out.append(current.data)
            current = current.next

        return str(out)


def remove_dups(ll):
    current = ll.head

    while current.next:
        current2 = current
        while current2.next:
            if current2.next.data == current.data:
                current2.next = current2.next.next
            else:
                current2 = current2.next

        current = current.next


def main():
    ll = LinkedList()
    ll.generate(100, 0, 9)
    print(ll)

    remove_dups(ll)

    print(ll)


if __name__ == '__main__':
    main()
