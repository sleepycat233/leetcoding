class Solution {
    private static final int VOWEL_COUNT = 5;
    private int count = 0;
    public int countVowelStrings(int n) {
        generateStirngs2(n, 0, 0);
        return count;
    }

    private void generateStirngs2(int n, int digits, int start) {
        if(digits == n) {
            ++count;
            return;
        }
        else {
            for(int i = start; i < VOWEL_COUNT; i++) {
                generateStirngs2(n, digits+1, i);
            }
        }
    }
}