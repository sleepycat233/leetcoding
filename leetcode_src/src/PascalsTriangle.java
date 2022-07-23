import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        if(numRows == 1) return res;
        res.add(List.of(1,1));
        for(int i = 3; i <= numRows; i++) {
            List<Integer> prev = res.get(i-2);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for(int j = 1; j < i-1; j++) {
                curr.add(prev.get(j-1)+prev.get(j));
            }
            curr.add(1);
            res.add(curr);
        }

        return res;
    }

    public List<List<Integer>> generate2(int numRows) {
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

    public static void main(String[] args) {
        PascalsTriangle sol = new PascalsTriangle();
        int row = 5;
        List<List<Integer>> ans = sol.generate2(row);
        for(int i = 0; i < row; i++) {
            System.out.println(ans.get(i));
        }
    }
}