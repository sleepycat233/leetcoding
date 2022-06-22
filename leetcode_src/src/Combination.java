import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Combination {
    public static int compute(int n, int r) {
        if(n == r) return 1;
        else if(n == 1) return 1;
        else if(r == 1) return n;
        else return compute(n-1, r-1) + compute(n-1, r);
    }

    private static void helper(List<int[]> combinations, int[] data, int start, int end, int index) {
        if(index == data.length) {
            combinations.add(data.clone());
        }
        else if(start <= end) {
            data[index] = start;
            // helper(combinations, data, start, end, index+1); // combination with repetition
            helper(combinations, data, start+1, end, index+1);
            helper(combinations, data, start+1, end, index);
        }
    }

    public static List<int[]> generateCombinations(int n, int k) {
        List<int[]> comb = new ArrayList<>();
        helper(comb, new int[k], 0, n-1, 0);
        return comb;
    }

    public static List<int[]> generateCombinations_iterative(int n, int k) {
        List<int[]> combinations = new ArrayList<>();
        int[] comb = new int[k];

        for(int i = 0; i < k; i++) {
            comb[i] = i;
        }

        while(comb[k-1] < n) {
            combinations.add(comb.clone());

            int t = k-1; // t is the digit on operation
            while(t != 0 && comb[t] == n-k+t) {
                t--;
            }
            comb[t]++;
            for(int i = t+1; i < k; i++) {
                comb[i] = comb[i-1] + 1;
            }
        }

        return combinations;
    }

    public static List<int[]> generateCombinationsWithRepetition_iterative(int n, int k) {
        List<int[]> combinations = new ArrayList<>();
/*         int[] comb = Stream.iterate(0, x -> x)
                        .limit(k)
                        .mapToInt(Integer::intValue)
                        .toArray();
 */

        int[] comb = new int[k];
        for(int i = 0; i < k; i++) {
            comb[i] = 0;
        }

        while(comb[k-1] < n) {
            combinations.add(comb.clone());

            int d = k-1;
            while(d != 0 && comb[d] == n-1) {
                d--;
            }
            comb[d]++;
            for(int i = d+1; i < k; i++) {
                comb[i] = comb[i-1];
            }
        }

        return combinations;
    }

    public static void main(String[] args) {
        // System.out.println(Combination.compute(10, 8));
        // List<int[]> res = Combination.generateCombinations(5, 2);
        // List<int[]> res = Combination.generateCombinations_iterative(4, 2);
        List<int[]> res = Combination.generateCombinationsWithRepetition_iterative(5, 2);
        for(int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(res.size());
    }
}