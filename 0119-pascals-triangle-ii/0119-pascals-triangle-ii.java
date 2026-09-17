class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> last = new ArrayList<>();     
        last.add(1);

        for(int i = 2; i <= rowIndex + 1; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(last.get(0));

            for(int j = 1; j < last.size(); j++) {
                temp.add(last.get(j - 1) + last.get(j));
            }

            temp.add(last.get(last.size() - 1));
            last = temp;
        }

        return last;
    }
}