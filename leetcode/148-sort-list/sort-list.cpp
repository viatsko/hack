/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

 struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
 };

class Solution {
public:
  ListNode* merge(ListNode *left, ListNode *right) {
    ListNode* sorted = new ListNode(0);
    ListNode* node = sorted;
    while (left && right) {
      if (left->val <= right->val) {
        node = node->next = left;
        left = left->next;
      } else {
        node = node->next = right;
        right = right->next;
      }
    }

    if (!left) {
      node->next = right;
    } else {
      node->next = left;
    }

    return sorted->next;
  }

  ListNode* sortList(ListNode* head) {
    if (!head || !head->next) {
      return head;
    }

    ListNode* slow = head;
    ListNode* fast = head->next;

    while (fast && fast->next) {
      slow = slow->next;
      fast = fast->next->next;
    }

    ListNode* mid = slow->next;
    slow->next = nullptr;

    return merge(sortList(head), sortList(mid));
  }
};
