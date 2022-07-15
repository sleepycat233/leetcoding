class Solution {
char[] elements = {'(', ')'};
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, new char[n*2], new int[]{0, 0}, 0, 0, n);

        return res;
    }

    private void helper(List<String> res, char[] run, int[] runQty, int ir, int balance, int n) {
        if(balance < 0) return;
        else if(ir == run.length) {
            res.add(new String(run));
        }
        else {
            for(int i = 0; i < elements.length; i++) {
                runQty[i]++;
                if(runQty[i] > n) {
                    runQty[i]--;
                    continue;
                }

                char e = elements[i];
                run[ir] = e;
                if(e == '(')
                    helper(res, run, runQty, ir + 1, balance+1, n);
                else
                    helper(res, run, runQty, ir + 1, balance-1, n);

                runQty[i]--;
            }
        }
    }
}