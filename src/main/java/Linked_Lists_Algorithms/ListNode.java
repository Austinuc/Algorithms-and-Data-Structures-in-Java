package Linked_Lists_Algorithms;

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
public class ListNode<T> {
    T val;
    ListNode<T> next;
    ListNode() {}
    ListNode(T val) { this.val = val; }
    ListNode(T val, ListNode<T> next) { this.val = val; this.next = next;}

    public void addNodeInFront(ListNode<T> node) {
        node.next = this.next;
        this.next = node;
    }
    public void addNodeAtEnd(ListNode<T> node) {
        ListNode<T> ptr = this;
        while (ptr != null) {
            if (ptr.next == null) {
                ptr.next = node;
                return;
            }
            ptr = ptr.next;
        }
    }

    public String toString(ListNode<T> head) {
        List<String> list = new ArrayList<>();
        if (head == null) return "[]";
        while(head != null) {
            list.add(String.valueOf(head.val));
            head = head.next;
        }
        return String.valueOf(list);
    }
}
