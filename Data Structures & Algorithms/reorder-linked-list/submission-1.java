class Solution {
    public void reorderList(ListNode head) {
        // step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // step 2: split secound half
        ListNode secound = slow.next;
        slow.next = null;


        // step 3:  reverse secound half alternatively
        ListNode curr = secound;
        ListNode prev = null;
        ListNode next;

        while(curr != null){
            // step 1: save next node
            next = curr.next;

            // step2: reverse link
            curr.next = prev;

            // move prev forward
            prev = curr;

            // move next forward
            curr = next;
        }

        secound = prev;

        ListNode first = head;
        // step 4 : merge both halves alternatively
        while(first != null && secound != null){
        

        ListNode temp1 = first.next;
        ListNode temp2 = secound.next;

        first.next = secound;
        secound.next  = temp1;

        first = temp1;
        secound = temp2;
    
        }
        
    }
}