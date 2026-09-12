class Solution {
    public int maxDepth(TreeNode root) {
            // base case
            if(root == null){
                return 0;
            }

            // recursive call
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            // find max depth
            return Math.max(left, right) + 1;
    }
}