class Solution {
    public int countVowelStrings(int n) {
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
}