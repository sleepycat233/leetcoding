

public class BinaryExponentiation {
    public static long pow(long b, long n) {
        long res = 1;
        while(n > 0) {
            if((n & 1) == 1) {
                res *= b;
            }
            b *= b;
            n >>= 1;
        }

        return res;
    }

    public static long binpow_rec(long b, long n) {
        if(n == 0)
            return 1;
        else if(n % 2 == 0)
            return binpow_rec(b*b, n/2);
        else
            return binpow_rec(b*b, (n-1)/2) * b;
    }

    public static void main(String[] args) {
        // System.out.println(pow(2,50));
        System.out.println(binpow_rec(2,50));
    }
}
