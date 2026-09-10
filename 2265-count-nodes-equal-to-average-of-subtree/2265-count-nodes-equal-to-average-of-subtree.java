class Solution {
    int ans = 0;

    public void helper(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }

        list.add(root.val);

        helper(root.left, list);
        helper(root.right, list);
    }

    public int averageOfSubtree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();

        helper(root, list);

        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        int average = sum / list.size();

        if (average == root.val) {
            ans++;
        }

        averageOfSubtree(root.left);
        averageOfSubtree(root.right);

        return ans;
    }
}