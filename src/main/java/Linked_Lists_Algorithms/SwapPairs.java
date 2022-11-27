package Linked_Lists_Algorithms;

public class SwapPairs {
    /**
     * Example: if you are given a list ordered A,B,C,D the resulting list should be B,A,D,C.
     * @param head
     * @return
     */
    public static ListNode<String> swapPairs(ListNode head) {

        if (head == null) return head;

        ListNode currNode = head, nextNode = currNode.next, prevNode = null;

        while (nextNode != null) {
            //swap current node with the next node
            currNode.next = nextNode.next;
            nextNode.next = currNode;

            if (prevNode != null) prevNode.next = nextNode;
            else head = nextNode;

            prevNode = currNode;
            currNode = currNode.next;
            nextNode = (currNode != null)? currNode.next : null;
        }

        return head;
    }
}

