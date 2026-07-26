/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {

    public Node flatten(Node head) {
        if (head == null)
            return head;

        dfs(head);
        return head;
    }

    private Node dfs(Node head) {

        Node curr = head;
        Node last = null;

        while (curr != null) {

            Node next = curr.next;

            if (curr.child != null) {

                Node child = curr.child;

                Node childTail = dfs(child);

                curr.next = child;
                child.prev = curr;
                curr.child = null;

                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                last = childTail;
                curr = childTail;
            } else {
                last = curr;
            }

            curr = curr.next;
        }

        return last;
    }
}