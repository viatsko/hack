class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class UnorderedList:
    def __init__(self):
        self.head = None

    def add(self, item):
        temp = Node(item)

        temp.next = self.head

        self.head = temp

    def remove(self, item):
        current = self.head

        previous = None

        found = False

        while not found:
            if current.data == item:
                found = True
            else:
                previous = current
                current = current.next

        if previous is None:
            self.head = current.next
        else:
            previous.setNext(current.next)

    def size(self):
        current = self.head

        count = 0

        while current is not None:
            count += 1

            current = current.next

        return count

    def search(self, item):
        current = self.head

        found = False

        while current is not None and not found:
            if current.data == item:
                found = True
            else:
                current = current.next

        return found
