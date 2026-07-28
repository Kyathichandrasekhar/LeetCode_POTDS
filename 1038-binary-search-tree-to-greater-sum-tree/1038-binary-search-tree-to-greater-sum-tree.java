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
    public void bst(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }

        bst(root.left,list);
        list.add(root.val);
        bst(root.right,list);
        
    }
    private void replacevalues(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }

        replacevalues(root.left,list);
        replacevalues(root.right,list);

        int nodeSum = 0;

        for(int i  : list){
            if(i>root.val){
                nodeSum+=i;

            }else{
                break;
            }
        }
        root.val +=nodeSum;
    }
    public TreeNode bstToGst(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        bst(root,list);
        Collections.reverse(list);
        replacevalues(root,list);
        return root;
    }
}