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
    Map<Integer, Integer> hm = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            hm.put(inorder[i], i);
        }
        return bt(preorder, 0, inorder.length-1);
    }
    int idx = 0;
    public TreeNode bt(int[] preorder, int low, int high) {
        if(low>high)return null;
        TreeNode node = new TreeNode(preorder[idx++]);
        int id = hm.get(node.val);
        node.left = bt(preorder, low, id-1);
        node.right = bt(preorder, id+1, high);
        return node;
    }
}