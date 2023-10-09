class ListNode {
    val: number;
    next: ListNode | null;
    
    constructor(val: number, next: ListNode | null = null) {
        this.val = val;
        this.next = next;
    }
}

function addTwoNumbers(l1: ListNode | null, l2: ListNode | null): ListNode | null {
    let sum = 0;
    let carry = 0;
    const l3 = new ListNode(0);
    let head: ListNode | null = l3;

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

    return head?.next;
}
