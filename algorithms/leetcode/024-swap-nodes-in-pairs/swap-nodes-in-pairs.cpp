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
    ListNode* swapPairs(ListNode* head) {
        ListNode* newHead = new ListNode(0);
        newHead->next = head;

        ListNode* prev = newHead;
        ListNode* current = head;
        while(current != nullptr) {
            if (current->next == nullptr) {
                break;
            }

            ListNode* tmp = current;
            ListNode* second = current->next;
            ListNode* next = current->next->next;

            prev->next = second;
            second->next = current;
            current->next = next;

            prev = current;
            current = next;
        }

        return newHead->next;
    }
};
