package LinkedListsAlgorithms;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        ListNode ptr = head;
        while (ptr != null) {
            i++;
            ptr = ptr.next;//move to next
        }
        ptr = head;
        for (int j = 0; j <= i-n; j++) {

            if (j == i - n - 1) { //because j starts from zero
                ptr.next = ptr.next.next;
                return head;
            }
            ptr = ptr.next;//move to next
        }
        return head.next;
    }

}
