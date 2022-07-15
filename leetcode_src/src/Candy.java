public class Candy {
    // two passes
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

        return res;
    }

    // greedy algorithm
    public int candy_greedy(int[] ratings) {
        int res = 0;
        int candy = 1;

        res = 1;
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                candy++;
                res += candy;
            }
            else {

            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Candy sol = new Candy();

        System.out.println(sol.candy(new int[]{1,0,2}));
    }
}
