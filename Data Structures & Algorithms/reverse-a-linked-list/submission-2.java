class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while(curr != null){
            // step 1: save the next node value
            next = curr.next;

            // step 2: reverse link
            curr.next = prev;

            // step 3: move prev froward
            prev = curr;

            // step 4: move curr forward
            curr = next;
        }

        return prev;
    }
}
