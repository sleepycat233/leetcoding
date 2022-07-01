import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    private Map<Character, String> mapOfLetters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty()) return res;

        combine(digits, res, new char[digits.length()], 0);
        return res;
    }

    private void combine(String digits, List<String> res, char[] run, int index) {
        if(index == digits.length()) {
            res.add(new String(run));
        }
        else {
            String group = mapOfLetters.get(digits.charAt(index));
            for(int i = 0; i < group.length(); i++) {
                run[index] = group.charAt(i);
                combine(digits, res, run, index+1);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber sol = new LetterCombinationsOfAPhoneNumber();
        System.out.println(sol.letterCombinations("23"));
        System.out.println(sol.letterCombinations("23").size());
    }
}
