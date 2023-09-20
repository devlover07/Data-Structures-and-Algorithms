/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Node nHead = null;

        if(head == null){
            return null;
        }

        HashMap<Node, Node> hm = new HashMap<>();

        nHead = new Node(head.val);
        hm.put(head, nHead);

        Node temp1 = head.next;
        Node temp2 = nHead;

        while(temp1!= null){
            temp2.next = new Node(temp1.val);
            temp2 = temp2.next;
            hm.put(temp1, temp2);
            temp1 = temp1.next;
        }

        temp1 = head;
        temp2 = nHead;
        Node node;

        while(temp1!=null){
            node = temp1.random;
            temp2.random = hm.get(node);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return nHead;
    }
}