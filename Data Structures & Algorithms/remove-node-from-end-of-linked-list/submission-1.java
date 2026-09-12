class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // move fast n step only
        for(int i=0; i<n; i++){
            fast = fast.next;
        }

        // move both fast and slow together
        while(fast.next != null){
            slow = slow.next;   // slow -> required -1
            fast = fast.next;   // fast -> last
        }

        // remove
        slow.next = slow.next.next;

        return dummy.next;
        
    }
}