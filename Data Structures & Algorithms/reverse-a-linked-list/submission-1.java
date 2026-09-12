class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while(curr != null){
            // step 1: store the next node
            next = curr.next;

            // step 2: reverse linkedlist
            curr.next = prev;

            // step 3: move prev forward
            prev = curr;

            // step 4: move curr forward
            curr = next;
        }

        return prev;
    }
}
