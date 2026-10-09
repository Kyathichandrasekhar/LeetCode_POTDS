class Solution {
    private static final long MOD = 1_000_000_007L;
    private long[][] tree;

    private void merge(int node, int lc, int rc) {
        long a00 = tree[lc][0], a01 = tree[lc][1], a10 = tree[lc][2], a11 = tree[lc][3];
        long b00 = tree[rc][0], b01 = tree[rc][1], b10 = tree[rc][2], b11 = tree[rc][3];

        tree[node][0] = Math.max(a00 + b10, a01 + b00);
        tree[node][1] = Math.max(a00 + b11, a01 + b01);
        tree[node][2] = Math.max(a10 + b10, a11 + b00);
        tree[node][3] = Math.max(a10 + b11, a11 + b01);
    }

    private void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            tree[node][0] = 0L;
            tree[node][1] = 0L;
            tree[node][2] = 0L;
            tree[node][3] = Math.max(0L, (long) nums[l]);
            return;
        }
        int mid = l + (r - l) / 2;
        int lc = 2 * node, rc = 2 * node + 1;
        build(lc, l, mid, nums);
        build(rc, mid + 1, r, nums);
        merge(node, lc, rc);
    }

    private void update(int node, int l, int r, int pos, int val) {
        if (l == r) {
            tree[node][0] = 0L;
            tree[node][1] = 0L;
            tree[node][2] = 0L;
            tree[node][3] = Math.max(0L, (long) val);
            return;
        }
        int mid = l + (r - l) / 2;
        int lc = 2 * node, rc = 2 * node + 1;
        if (pos <= mid) update(lc, l, mid, pos, val);
        else update(rc, mid + 1, r, pos, val);
        merge(node, lc, rc);
    }

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        int n = nums.length;
        tree = new long[4 * n][4];
        build(1, 0, n - 1, nums);

        long totalSum = 0;
        for (int[] q : queries) {
            update(1, 0, n - 1, q[0], q[1]);
            totalSum = (totalSum + tree[1][3]) % MOD;
        }
        return (int) totalSum;
    }
}