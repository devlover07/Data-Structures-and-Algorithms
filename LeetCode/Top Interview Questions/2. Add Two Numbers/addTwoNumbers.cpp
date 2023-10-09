class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int sum = 0;
        int carry = 0;
        ListNode* l3 = new ListNode();
        ListNode* head = l3;

        while (l1 || l2) {
            sum = 0;

            if (l1) {
                sum += l1->val;
                l1 = l1->next;
            }

            if (l2) {
                sum += l2->val;
                l2 = l2->next;
            }
            sum += carry;
            carry = sum / 10;
            sum %= 10;
            l3->next = new ListNode(sum);
            l3 = l3->next;
        }

        if (carry != 0) {
            l3->next = new ListNode(carry);
        }

        return head->next;
    }
};
