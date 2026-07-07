// Last updated: 7/7/2026, 11:01:22 PM
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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        trav(root, list);
        return list.get(k - 1);
    }
    public void trav(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        trav(node.left, list);
        list.add(node.val);
        trav(node.right, list);
    }
}
