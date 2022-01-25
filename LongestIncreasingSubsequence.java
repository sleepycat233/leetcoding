import java.util.*;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] t = new int[nums.length];
        int len = 1;
        for(int i = 0; i < nums.length; i++) {
            t[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    t[i] = Math.max(t[i], t[j] + 1);
                }
            }
            len = Math.max(len, t[i]);
        }

        return len;
    }

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] d = new int[n+1];
        int len = 1;
        d[len] = nums[0];

        for(int i = 1; i < n; i++) {
            if(nums[i] > d[len]) {
                d[++len] = nums[i];
            }
            else {
                for(int j = 1; j <= len; j++) {
                    if(nums[i] > d[j]) {
                        d[j] = nums[i];
                        len = j;
                        break;
                    }
                }
            }
        }

        return len;
    }

    public int[] sequenceOfLIS(int[] nums) {
        int n = nums.length;
        // List<List<Integer>> t = new ArrayList<List<Integer>>();
        List<List<Integer>> t = new ArrayList<>();
        t.add(new ArrayList<>());
        t.get(0).add(nums[0]);
        int len = 0, maxlen = 0;
        int maxpos = 0;

        for(int i = 1; i < n; i++) {
            t.add(new ArrayList<>());
            t.get(i).add(nums[i]);
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(t.get(j).size()+1 > t.get(i).size()) {
                        t.set(i, deepCopy(t.get(j)));
                        t.get(i).add(nums[i]);
                        if((len = t.get(i).size()) > maxlen) {
                            maxlen = len;
                            maxpos = i;
                        }
                    }
                    else {
                        ;
                    }
                }
                else {
                    // t.get(i).add(nums[i]);
                }
            }
        }
        return t.get(maxpos).stream().mapToInt(i -> i).toArray();
    }

    private <E> List<E> deepCopy(List<E> list) {
        List<E> newList = new ArrayList<>();
        Iterator<E> ite = list.iterator();

        while(ite.hasNext()) {
            newList.add(ite.next());
        }
        return newList;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence();
        // System.out.println(sol.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
        // System.out.println(sol.lengthOfLIS(new int[] {1, 3, 6, 7, 9, 4, 10, 5, 6}));
        // System.out.println(sol.lengthOfLIS(new int[] {1}));

        // System.out.println(Arrays.toString(sol.sequenceOfLIS(new int[] {1})));
        // System.out.println(Arrays.toString(sol.sequenceOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18})));
        System.out.println(Arrays.toString(sol.sequenceOfLIS(new int[] {1, 3, 6, 7, 9, 4, 10, 5, 6})));
    }
}
