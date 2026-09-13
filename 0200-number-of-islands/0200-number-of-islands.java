class Solution {
    public void dfs(char[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        // boundary check
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return;
        }
        // water or already visited
        if (grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        // up
        dfs(grid, i - 1, j, m, n, visited);
        // down
        dfs(grid, i + 1, j, m, n, visited);
        // left
        dfs(grid, i, j - 1, m, n, visited);
        // right
        dfs(grid, i, j + 1, m, n, visited);
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;       // rows
        int m = grid[0].length;    // columns

        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;

                    dfs(grid, i, j, m, n, visited);
                }
            }
        }
        return count;
    }
}