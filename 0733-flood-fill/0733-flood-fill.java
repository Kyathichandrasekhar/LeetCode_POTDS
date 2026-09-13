class Solution {
    public void dfs(int[][] image, int sr, int sc, int color,
                    int[][] ans, boolean[][] visited,
                    int originalColor, int n, int m) {

        if (sr < 0 || sr >= n || sc < 0 || sc >= m) {
            return;
        }

        if (image[sr][sc] != originalColor || visited[sr][sc]) {
            return;
        }

        visited[sr][sc] = true;
        ans[sr][sc] = color;

        dfs(image, sr - 1, sc, color, ans, visited, originalColor, n, m);
        dfs(image, sr + 1, sc, color, ans, visited, originalColor, n, m);
        dfs(image, sr, sc - 1, color, ans, visited, originalColor, n, m);
        dfs(image, sr, sc + 1, color, ans, visited, originalColor, n, m);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;

        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            ans[i] = image[i].clone();
        }
        boolean[][] visited = new boolean[n][m];

        int originalColor = image[sr][sc];

        dfs(image, sr, sc, color, ans, visited, originalColor, n, m);
        return ans;
    }
}