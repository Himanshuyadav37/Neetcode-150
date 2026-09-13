class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {

        // Step 1: Base case
        if (node == null) {
            return 0;
        }

        // Step 2: Left contribution
        int left = Math.max(0, dfs(node.left));

        // Step 3: Right contribution
        int right = Math.max(0, dfs(node.right));

        // Step 4: Path passing through current node
        int currentPath = node.val + left + right;

        // Step 5: Update global maximum
        maxSum = Math.max(maxSum, currentPath);

        // Step 6: Return one-sided path to parent
        return node.val + Math.max(left, right);
    }
}