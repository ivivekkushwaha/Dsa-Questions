class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return dot(root, 0);
    }

    public int dot(TreeNode root, int sum) {
        if (root == null) return sum;

        int left = md(root.left);
        int right = md(root.right);

        sum = Math.max(left + right, sum);

        sum = dot(root.left, sum);
        sum = dot(root.right, sum);

        return sum;
    }

    public int md(TreeNode node) {
        if (node == null) return 0;

        return 1 + Math.max(md(node.left), md(node.right));
    }
}