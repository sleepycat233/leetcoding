import java.util.*;

public class HappyNumber {
    public static void wait(int ms)
    {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    /**
     * 2^2 = 4
     * 4^2 = 16
     * 1^2 + 6^2 = 37
     * 3^2 + 7^2 = 58
     */
    // time O(log_10(n)), bec the second while-loop loops through each digit and log_10(10) digits in total.
    public boolean isHappyNumber(int n) {
        int sum = 0;
        Set<Integer> s = new HashSet<>();
        while(n != 1) {
            while(n > 0) {
                sum += (n%10)*(n%10);
                n/=10;
            }
            System.out.format("sum %s\n", sum);
            wait(500);
            if(!s.add(sum)) return false;
            n = sum;
            sum = 0;
        }
        return true;
    }

    

    public static void main(String[] args) {
        HappyNumber sol = new HappyNumber();
        System.out.println(sol.isHappyNumber(999));

        // for(int i = 1; i < 10001; i++) {
        //     if(sol.isHappyNumber(i) == true) {
        //         System.out.format("%d, ", i);
        //     }
        // }
        // System.out.println();
    }
}
