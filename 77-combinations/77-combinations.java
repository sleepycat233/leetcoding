class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new Integer[k], 0, 0, n);
        return res;
    }
    
    private void helper(List<List<Integer>> res, Integer[] run, int index, int start, int n) {
        if(index == run.length) {
            res.add(Arrays.asList(run.clone()));
        }
        else {
            for(int i = start; i < n; i++) {
                run[index] = i+1;
                helper(res, run, index+1, i+1, n);
            }
            
        }
    }
}