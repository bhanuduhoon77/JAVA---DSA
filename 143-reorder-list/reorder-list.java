class Solution {

    public ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public void reorderList(ListNode head) {

        if (head == null || head.next == null)
            return;

        ListNode leftMiddle = middleNode(head);

        ListNode head2 = leftMiddle.next;
        leftMiddle.next = null;

        head2 = reverseList(head2);

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (head != null && head2 != null) {

            ListNode next1 = head.next;
            ListNode next2 = head2.next;

            temp.next = head;
            temp = temp.next;

            temp.next = head2;
            temp = temp.next;

            head = next1;
            head2 = next2;
        }

        if (head != null)
            temp.next = head;

        if (head2 != null)
            temp.next = head2;
    }
}