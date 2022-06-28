class Solution {
    private Map<Character, String> mapOfLetters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        List<String> letters = new ArrayList<>();
                if(digits.isEmpty()) return res;
        for(int i = 0; i < digits.length(); i++) {
            letters.add(mapOfLetters.get(digits.charAt(i)));
        }
        combine(letters, 0, res, new char[digits.length()], 0);
        return res;
    }

    private void combine(List<String> letters, int n, List<String> res, char[] run, int size) {
        if(size == letters.size()) {
            res.add(new String(run));
        }
        else {
            String group = letters.get(n);
            for(int i = 0; i < group.length(); i++) {
                run[size] = group.charAt(i);
                combine(letters, n+1, res, run, size+1);
            }
        }
    }
}