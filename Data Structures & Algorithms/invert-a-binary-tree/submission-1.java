class Solution {
    public TreeNode invertTree(TreeNode root) {
            // step 1: if root == null means no child
            if(root == null){
                return null;
            }

            // step 2: call invertTree for left and right and store in a node
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);

            // step 3: put value of node left into right and vice-versa
            root.right = left;
            root.left = right;

            return root;
    }
}