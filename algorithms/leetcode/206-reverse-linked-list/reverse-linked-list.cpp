/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode *prev = nullptr;
        ListNode *node = head;
        while (node) {
            ListNode *tmp = node->next;
            node->next = prev;
            prev = node;
            node = tmp;
        }
        return prev;
    }
};
