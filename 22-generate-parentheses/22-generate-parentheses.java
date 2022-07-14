class Solution {
public List<String> generateParenthesis(int n) {
return generateCombinationsTest(new Character[]{'(', ')'}, new int[]{n, n});
    }

    public <E> List<String> generateCombinationsTest(E[] elements, int[] quantity) {
        List<String> res = new ArrayList<>();
        if(elements.length != quantity.length) return res;

        int nOfSlot = 0;
        for(int q : quantity) nOfSlot += q;

        helper(res, (E[]) new Object[nOfSlot], 0, new int[quantity.length], elements, quantity);
        res = res.stream()
                .filter(str -> validate(str))
                .collect(Collectors.toList());

        return res;
    }

    private <E> void helper(List<String> res, E[] run, int ri, int[] runQty, E[] elements, int[] quantity) {
        if(ri == run.length) {
            StringBuilder sb = new StringBuilder();
            for(E e : run) {
                sb.append(e);
            }
            res.add(sb.toString());
        }
        else {
            for(int i = 0; i < elements.length; i++) {
                runQty[i]++;
                if (runQty[i] > quantity[i]) {
                    runQty[i]--;
                    continue;
                }

                run[ri] = elements[i];
                helper(res, run, ri+1, runQty, elements, quantity);
                runQty[i]--;
            }
        }
    }

    private boolean validate(String str) {
        int balance = 0;

        for(char c : str.toCharArray()) {
            if(c == ')') balance--;
            else balance++;

            if(balance < 0) return false;
        }

        return balance == 0;
    }
}