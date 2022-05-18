import java.util.ArrayList;
import java.util.List;

public class CountSortedVowelStrings {
    // bruteforce - recursion with backtracing
    char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
    List<String> res = new ArrayList<>();
    public int countVowelStrings(int n) {

        generateStrings(new StringBuilder(), n, 0);

        // System.out.println(res);
        return res.size();
    }

    private void generateStrings(StringBuilder sb, int n, int start) {
        if(sb.length() == n) {
            res.add(sb.toString());
            return;
        }

        for(int i = start; i < vowels.length; i++) {
            StringBuilder newSb = new StringBuilder(sb.toString());
            newSb.append(vowels[i]);
            generateStrings(newSb, n, i);
        }
    }

    private static final int VOWEL_COUNT = 5;
    private int count = 0;
    public int countVowelStrings2(int n) {
        generateStrings2(n, 0, 0);
        return count;
    }

    private void generateStrings2(int n, int digits, int start) {
        if(digits == n) {
            ++count;
            return;
        }
        else {
            for(int i = start; i < VOWEL_COUNT; i++) {
                generateStrings2(n, digits+1, i);
            }
        }
    }

    public int countVowelStrings3(int n) {
        return countv(n, 1);
    }

    private int countv(int n, int pos) {
        if(n == 0) return 1;
        else {
            int result = 0;
            for(int v = pos; v <= 5; v++) {
                result += countv(n - 1, v);
            }
            return result;
        }
    }


    public static void main(String[] args) {
        CountSortedVowelStrings sol = new CountSortedVowelStrings();
        System.out.println(sol.countVowelStrings3(2));
    }
}
