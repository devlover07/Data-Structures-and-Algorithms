class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def addTwoNumbers(l1, l2):
    dummy_head = ListNode(0)
    current = dummy_head
    carry = 0

    while l1 or l2:
        # Get the values of the current nodes (if available)
        x = l1.val if l1 else 0
        y = l2.val if l2 else 0

        # Calculate the sum of current digits and the carry from the previous step
        _sum = x + y + carry

        # Update carry for the next calculation
        carry = _sum // 10

        # Create a new node with the sum % 10 as its value and move the current pointer
        current.next = ListNode(_sum % 10)
        current = current.next

        # Move to the next nodes if available
        if l1:
            l1 = l1.next
        if l2:
            l2 = l2.next

    # If there's a carry left after the loop, create an additional node
    if carry > 0:
        current.next = ListNode(carry)

    return dummy_head.next
