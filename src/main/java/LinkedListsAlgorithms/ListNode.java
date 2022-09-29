package LinkedListsAlgorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}

    public void addNodeInFront(ListNode node) {
        node.next = this.next;
        this.next = node;
    }
    public void addNodeAtEnd(ListNode node) {
        ListNode ptr = this;
        while (ptr != null) {
            if (ptr.next == null) {
                ptr.next = node;
                return;
            }
            ptr = ptr.next;
        }
    }

    public String toString(ListNode head) {
        List<String> list = new ArrayList<>();
        if (head == null) return "[]";
        while(head != null) {
            list.add(String.valueOf(head.val));
            head = head.next;
        }
        return String.valueOf(list);
    }
}
