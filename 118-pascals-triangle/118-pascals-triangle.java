class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, numRows);
        return res;
    }

    private void helper(List<List<Integer>> res, int row) {
        if(row == 1) {
            res.add(List.of(1));
        }
        else {
            helper(res, row-1);

            List<Integer> prev = res.get(row-1-1);
            List<Integer> curr = new ArrayList<>();

            curr.add(1);
            for(int i = 1; i < prev.size(); i++) {
                curr.add(prev.get(i-1)+prev.get(i));
            }
            curr.add(1);

            res.add(curr);
        }
    }
}