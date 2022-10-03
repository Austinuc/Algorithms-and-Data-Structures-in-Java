package Linked_Lists_Algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveNthNodeFromEndTest {

    @Test
    public void testRemoveNthFromEnd() {
        ListNode head = new ListNode(1);
        head.addNodeInFront(new ListNode(2));
        head.next.addNodeInFront(new ListNode(3));
        head.next.next.addNodeInFront(new ListNode(4));
        head.next.next.next.addNodeInFront(new ListNode(5));
        new RemoveNthNodeFromEnd().removeNthFromEnd(head, 2);
        assertEquals("[1, 2, 3, 5]", head.toString(head));
    }

    @Test
    public void testRemoveNthFromSingleList() {
        ListNode head = new ListNode(1);
        assertEquals("[]", head.toString(new RemoveNthNodeFromEnd().removeNthFromEnd(head, 1)));
    }

    @Test
    public void testRemoveNthFromEnd2() {
        ListNode head = new ListNode("a");
        head.addNodeAtEnd(new ListNode("b"));
        head.addNodeAtEnd(new ListNode("c"));
        head.addNodeAtEnd(new ListNode("d"));
        head.addNodeAtEnd(new ListNode("e"));
        assertEquals("[a, b, c, d]", head.toString(new RemoveNthNodeFromEnd().removeNthFromEnd(head, 1)));
    }
}