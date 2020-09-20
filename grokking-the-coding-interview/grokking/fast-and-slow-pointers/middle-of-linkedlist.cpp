using namespace std;

#include <iostream>

class ListNode {
 public:
  int value = 0;
  ListNode *next;

  ListNode(int value) {
    this->value = value;
    next = nullptr;
  }
};

class MiddleOfLinkedList {
 public:
  static ListNode *findMiddle(ListNode *head) {
    ListNode *slow = head;
    ListNode *fast = head;
    while (fast != nullptr && fast->next != nullptr) {
      slow = slow->next;
      fast = fast->next->next;
    }
    return slow;
  }
};

int main(int argc, char *argv[]) {
  ListNode *head = new ListNode(1);
  head->next = new ListNode(2);
  head->next->next = new ListNode(3);
  head->next->next->next = new ListNode(4);
  head->next->next->next->next = new ListNode(5);
  cout << "Middle Node: " << MiddleOfLinkedList::findMiddle(head)->value << endl;

  head->next->next->next->next->next = new ListNode(6);
  cout << "Middle Node: " << MiddleOfLinkedList::findMiddle(head)->value << endl;

  head->next->next->next->next->next->next = new ListNode(7);
  cout << "Middle Node: " << MiddleOfLinkedList::findMiddle(head)->value << endl;
}
