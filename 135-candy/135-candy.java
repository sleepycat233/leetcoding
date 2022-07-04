class Solution {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        left[0] = 1;
        right[ratings.length-1] = 1;

        for (int i = 1; i < ratings.length; i++) {
            left[i] = (ratings[i] > ratings[i - 1]) ? left[i - 1] + 1 : 1;
        }
        for (int j = ratings.length-2; j >= 0; j--) {
            right[j] = (ratings[j] > ratings[j + 1]) ? right[j + 1] + 1 : 1;
        }

        int res = 0;
        for(int k = 0; k < ratings.length; k++) {
            res += Math.max(left[k], right[k]);
        }

        return res;    }
}