class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        HashMap<Node, Node> m = new HashMap<>();

        Node newHead = new Node(head.val);
        m.put(head, newHead);

        Node oldTemp = head.next;
        Node newTemp = newHead;

        // Step 1: Create copied nodes
        while (oldTemp != null) {

            Node copyNode = new Node(oldTemp.val);

            m.put(oldTemp, copyNode);

            // Connect copied nodes
            newTemp.next = copyNode;

            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        // Step 2: Connect random pointers
        oldTemp = head;
        newTemp = newHead;

        while (oldTemp != null) {

            newTemp.random = m.get(oldTemp.random);

            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        return newHead;
    }
}