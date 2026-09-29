// Last updated: 9/29/2026, 11:14:01 AM
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
    
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int current) {
        if (node == null) {
            return 0;
        }
        
        // Form the binary number
        current = current * 2 + node.val;
        
        // If leaf node, return the number formed
        if (node.left == null && node.right == null) {
            return current;
        }
        
        // Recur left and right
        return dfs(node.left, current) + dfs(node.right, current);
    }
}