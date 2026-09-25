class Solution {
    public boolean dfs(int node, List<List<Integer>> adj,
                       boolean[] visited, boolean[] pathVisited,
                       Stack<Integer> st) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int it : adj.get(node)) {

            // If neighbour is not visited, visit it
            if (!visited[it]) {
                if (dfs(it, adj, visited, pathVisited, st)) {
                    return true;
                }
            }

            // Neighbour is already in current DFS path
            else if (pathVisited[it]) {
                return true;
            }
        }

        pathVisited[node] = false;
        st.push(node);

        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] pair : prerequisites) {

            int course = pair[0];
            int prerequisite = pair[1];

            adj.get(prerequisite).add(course);
        }

        boolean[] visited = new boolean[numCourses];

        // Tracks nodes in the CURRENT DFS path
        boolean[] pathVisited = new boolean[numCourses];

        Stack<Integer> st = new Stack<>();

        // DFS for every course
        for (int i = 0; i < numCourses; i++) {

            if (!visited[i]) {

                if (dfs(i, adj, visited, pathVisited, st)) {
                    return new int[0];
                }
            }
        }

        // Convert stack to answer
        int[] ans = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            ans[i] = st.pop();
        }

        return ans;
    }
}