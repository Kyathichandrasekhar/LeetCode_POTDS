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
    int max = Integer.MIN_VALUE;
    public int PathSum(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftsum = Math.max(0,PathSum(root.left));
        int rightsum = Math.max(0,PathSum(root.right));

        max = Math.max(leftsum+rightsum+root.val,max);
        return root.val+Math.max(leftsum,rightsum);
    }
    public int maxPathSum(TreeNode root) {
        PathSum(root);

        return max;
    }
}