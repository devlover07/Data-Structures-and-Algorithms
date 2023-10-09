class ListNode {
    constructor(val = 0, next = null) {
        this.val = val;
        this.next = next;
    }
}

function addTwoNumbers(l1, l2) {
    let sum = 0;
    let carry = 0;
    const l3 = new ListNode();
    let head = l3;

    while (l1 || l2) {
        sum = 0;

        if (l1) {
            sum += l1.val;
            l1 = l1.next;
        }

        if (l2) {
            sum += l2.val;
            l2 = l2.next;
        }
        sum += carry;
        carry = Math.floor(sum / 10);
        sum %= 10;
        l3.next = new ListNode(sum);
        l3 = l3.next;
    }

    if (carry !== 0) {
        l3.next = new ListNode(carry);
    }

    return head.next;
}
