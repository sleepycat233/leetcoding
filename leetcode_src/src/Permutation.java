import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation<E> {
    public static <E> List<List<E>> generatePermutation(List<E> items) {
        List<List<E>> res = new ArrayList<>();
        helper(res, items.size(), items, new ArrayList<>());
        return res;
    }

    private static <E> void helper(List<List<E>> res, int n, List<E> items, List<E> run) {
        if(run.size() == n) {
            res.add(run.stream()
                        .collect(Collectors.toList()));
        }
        else {
            for(int i = 0; i < items.size(); i++) {
                List<E> remainings = items.stream()
                                        .collect(Collectors.toList());
                run.add(remainings.get(i));
                remainings.remove(i);
                helper(res, n, remainings, run);
                run.remove(run.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        // List<String> l = List.of("a", "b", "cc");
        List<Integer> l = List.of(1, 2, 3);

        List<List<Integer>> res = Permutation.generatePermutation(l);
        System.out.println(res.toString());
    }
}
