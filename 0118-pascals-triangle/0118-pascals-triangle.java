class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int r = 1; r <= numRows; r++) {
            ArrayList<Integer> row = new ArrayList<>();

            row.add(1);

            for (int i = 1; i < r; i++) {
                row.add((row.get(i - 1) * (r - i)) / i);
            }

            ans.add(row);
        }

        return (List) ans;
    }
}