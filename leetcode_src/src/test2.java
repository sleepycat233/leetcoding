class test2  {
    public static int calc(int x) {
        int i = 4, j = -9;
        int y = -13;

        while(i > j) {
            if(y % 2 == 0) {
                y = x + y;
            }
            else {
                y += 1;
            }

            i--;
            j += 3;

        }

        return y;
    }

    public static int Fibonacci(int n) {
        int[] table = new int[]{0, 1};
        if (n <= 0) return 0;
        n -= 1;
        while(n > 1) {
            int x = table[0] + table[1];
            table[0] = table[1];
            table[1] = x;
            n--;
        }
        return table[n];
    }

    public static void main(String[] args) {
        // System.out.println(test2.calc(7));
        for(int i = 0; i < 20; i++) {
            System.out.println(test2.Fibonacci(i));
        }

    }
}