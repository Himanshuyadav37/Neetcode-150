class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next;

        while(current != null){
            // first save the next
            next = current.next;

            // reverse 
            current.next = prev;

            // move prev forward
            prev = current;

            // move current forward
            current = next;
        }
        return prev;
    }
}
