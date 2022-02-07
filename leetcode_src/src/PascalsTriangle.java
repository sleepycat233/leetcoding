import java.util.*;

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

    public static void main(String[] args) {
        PascalsTriangle sol = new PascalsTriangle();
        List<List<Integer>> ans = sol.generate(30);
        for(int i = 0; i < 30; i++) {
            System.out.println(ans.get(i));
        }
    }
}