package dp;

import java.util.*;

public class dp {

    public static int[] sort(int[] arr) {
        for(int j = 1; j < arr.length; j++) {
            int i = j-1;
            int key = arr[j];
            while(i >= 0 && arr[i] > key) {
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = key;
        }

        return arr;
    }


    // given a number t, and an array of numbers n
    // determine whether or not t is a sum of numbers from n. each element in n can be used for multiple times.
    // time complexity analysis:
    // the program has a tree structure and thus O(b^n)
    // suppose there are n numbers in the array,
    // n will become the braching factor, and thus becomes the base
    // the tree has an height of m
    // therefore, O(n^m)
    // space complexity: O(m) with m being the height of the tree
    private static boolean canSum(int target, int[] numbers) {
        if(target == 0) {
            return true;
        }
        else if (target < 0) {
            return false;
        }

        for(int i = 0; i < numbers.length; ++i) {
            int res = target - numbers[i];
            if(canSum(res, numbers) == true) {
                return true;
            }
        }

        return false;
    }

    // memo contains false case.
    private static boolean canSum_memo(int target, int[] numbers, List<Integer> memo)
    {
        if (memo.contains(target)) {
            return false;
        }
        else if (target == 0) {
            return true;
        }
        else if (target < 0) {
            return false;
        }

        for (int i = 0; i < numbers.length; ++i) {
            int res = target - numbers[i];
            if (canSum_memo(res, numbers, memo) == true) {
                return true;
            }
        }

        memo.add(target);
        return false;
    }

    // time: O(m*n)
    // space: O(m)
    public static boolean cansum_tab(int tar, int[] nums) {
        boolean[] tab = new boolean[tar+1];
        tab[tar] = true;

        for(int i = tar; i > 0; i--) {
            if(tab[i] == true) {
                for(int n : nums) {
                    if(i-n >= 0)
                        tab[i-n] = true;
                }
            }
        }

        // System.out.println(Arrays.toString(tab));

        return tab[0];
    }

    private static boolean howSum(int target, int[] numbers, List<Integer> rl) {
        if (target == 0) {
            return true;
        }
        else if (target < 0) {
            return false;
        }

        for (int i = 0; i < numbers.length; ++i) {
            int res = target - numbers[i];
            if (howSum(res, numbers, rl) == true) {
                rl.add(numbers[i]);
                return true;
            }
        }

        return false;
    }

    // 8, [2,3,5] - return [3,5], but not [2,2,2,2]
    private static List<Integer> bestSum(int tar, int[] nums)
    {
        if(tar == 0) {
            return new ArrayList<>();
        }
        else if(tar < 0) {
            return null;
        }

        List<Integer> curr_comb = null;
        List<Integer> best_comb = null;

        for (int i = 0; i < nums.length; ++i) {
            int res = tar - nums[i];
            if ((curr_comb = bestSum(res, nums)) != null) {
                curr_comb.add(nums[i]);
                if(best_comb == null || curr_comb.size() < best_comb.size()) {
                    best_comb = curr_comb;
                }
            }
        }

        return best_comb;
    }

    public static int[] bestSum_tab(int tar, int[] nums) {
        List<List<Integer>> tab = new ArrayList<>(tar+1);

        for(List<Integer> list : tab) {
            list = new ArrayList<>();
        }


        System.out.println(tab.get(3));

        return null;
    }

    //"ABCDABA", {"CD", "AB", "A"}
    // given a string s1 and an array of strings pat,
    // reture true or false on whether or not s1 can be constructed by concatenating strings from pat.

    // time: O(m * n * n)
    // substring() method is O(n)
    public static boolean canConstruct(String str, String[] patterns) {
/*
        boolean[][] cache = new boolean[patterns.length][str.length()];

        for(int col = 0; col < cache.length; col++) {
            for(int row = 0; row < cache[0].length; row++) {
                for(int i = 0; i < patterns[col].length(); i++) {
                    if(str.charAt(row) == patterns[col].charAt(i)) {
                        cache[col][row] = true;
                        row++;
                    }
                }
            }
        }
 */
        boolean[] tab = new boolean[str.length()+1];
        tab[0] = true;

        for(int i = 0; i < str.length(); i++) {
            if(tab[i] == true) {
                for(int j = 0; j < patterns.length; j++) {
                    // System.out.format("i %s\n", i);
                    // System.out.format("patterns[%d] %s\n", j, patterns[j]);
                    if(i + patterns[j].length() > tab.length-1) {
                        continue;
                    }
                    else if (patterns[j].compareTo(str.substring(i, i + patterns[j].length())) == 0) {
                        tab[i + patterns[j].length()] = true;
                    }
                    // System.out.format("tab %s\n", Arrays.toString(tab));
                }
            }
        }

        return tab[tab.length-1];
    }

    public static void main(String[] args) {

        // int[] a = {2, 3, 4, 1, 5, 9, 1, 3};
        // sort(a);

        // System.out.println(Arrays.toString(a));

        int t = 8;
        int[] n = {2, 3, 5};
        // List<Integer> memo = new ArrayList<>(20);
        // System.out.println("t = " + t);
        // System.out.printf("canSum(%d): %b\n", t, canSum_memo(t, n, memo));
        // System.out.println(memo.toString());
        System.out.println(cansum_tab(t, n));
        // System.out.println(howSum(t, n, memo));

        List<Integer> r = new ArrayList<>(20);
        howSum(t, n, r);
        System.out.printf("howSum(%d): %s\n", t, r.toString());

        // List<Integer> a;
        // a = bestSum(t, n);
        // System.out.println(a.toString());

        //"ABCDABA", {"CD", "AB", "A"}
        // String[] p = {"bo", "rd", "ate", "t", "sta", "sk", "boar"};
        // String[] p = {"ab", "c", "abcd"};
        // System.out.println(canConstruct("skateboard", p));

        System.out.println(bestSum_tab(t, n));
    }
}
