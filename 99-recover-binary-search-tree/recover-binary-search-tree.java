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
    TreeNode g[] = new TreeNode[3];
    int count = 0;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        validTree(root);
        if(count==1){
            int temp = g[0].val;
            g[0].val = g[1].val;
            g[1].val = temp;
        }else{
            int temp = g[0].val;
            g[0].val = g[2].val;
            g[2].val = temp;
        }

    }

    public void validTree(TreeNode root) {
        if (root == null)
            return;
        validTree(root.left);
        if (prev != null && root.val <= prev.val) {
            count++;
            if (g[0] == null) {
                g[0] = prev;
                g[1] = root;
            } else {
                g[2] = root;
                
            }
        }
            prev = root;

       
        validTree(root.right);

    }

}