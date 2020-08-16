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

    exist = {current.data}

    while current.next:
        if current.next.data in exist:
            current.next = current.next.next
        else:
            exist.add(current.next.data)
            current = current.next


def main():
    ll = LinkedList()
    ll.generate(100, 0, 9)
    print(ll)

    remove_dups(ll)

    print(ll)


if __name__ == '__main__':
    main()
