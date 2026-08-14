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
    public TreeNode bstFromPreorder(int[] preorder) {
        // your code goes here
        TreeNode node = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            insert(node, preorder[i]);
        }

        return node;
    }

    public void insert(TreeNode root, int data) {
        if (data < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(data);
            } else {
                insert(root.left, data);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(data);
            } else {
                insert(root.right, data);
            }
        }
    }
}