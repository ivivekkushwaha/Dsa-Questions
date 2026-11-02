/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validTree(root);
    }
    TreeNode prev = null;
    public boolean validTree(TreeNode root) {
        if(root == null)return true;
        boolean left = validTree(root.left);
        if(prev!=null && root.val<=prev.val)return false;
        prev = root;
       boolean right = validTree(root.right);
        return left && right;
    }
}