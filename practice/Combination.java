public class Combination {
    public static int compute(int n, int r) {
        if(n == 1) return 1;
        else if(r == 1) return n;
        else return compute(n-1, r-1) + compute(n-1, r);
    }

    public static void main(String[] args) {
        System.out.println(Combination.compute(4, 2));
    }
}