
class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode root) {

        // Base case
        if (root == null) {
            return 0;
        }

        // Left subtree ki height
        int leftHeight = checkHeight(root.left);

        // Left subtree balanced nahi hai
        if (leftHeight == -1) {
            return -1;
        }

        // Right subtree ki height
        int rightHeight = checkHeight(root.right);

        // Right subtree balanced nahi hai
        if (rightHeight == -1) {
            return -1;
        }

        // Current node ka balance check
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Current node ki height
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
