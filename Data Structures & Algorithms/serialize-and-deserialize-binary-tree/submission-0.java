public class Codec {

    int idx = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "null";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        idx = 0;

        return build(arr);
    }

    private TreeNode build(String[] arr){
        String value = arr[idx++];

        if(value.equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));

        root.left = build(arr);
        root.right = build(arr);

        return root;
    }
}
