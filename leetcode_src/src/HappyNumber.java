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
            // System.out.format("sum %s\n", sum);
            // wait(500);
            if(!s.add(sum)) return false;
            n = sum;
            sum = 0;
        }
        return true;
    }

    //通过反复调用 getNext(n) 得到的链是一个隐式的链表。隐式意味着我们没有实际的链表节点和指针，但数据仍然形成链表结构
    // https://www.wikiwand.com/en/Cycle_detection#/Example
    // 所以可以用 - 快慢指针

    private int getNext(int n) {
        int sum = 0;
        while(n > 0) {
            sum += (n%10) * (n%10);
            n /= 10;
        }
        return sum;
    }

    public boolean isHappyNumber2(int n) {
        int slow = n, fast = n;
        while(fast != 1) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
            if(slow == fast) break;
        }
        return (fast == 1);
    }


    public static void main(String[] args) {
        HappyNumber sol = new HappyNumber();
        System.out.println(sol.isHappyNumber(999));

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for(int i = 1; i < 100; i++) {
            if(sol.isHappyNumber(i) == true) {
                l1.add(i);
            }
            if(sol.isHappyNumber2(i) == true) {
                l2.add(i);
            }
        }
        System.out.println(Arrays.toString(l1.toArray()));
        System.out.println(Arrays.toString(l2.toArray()));
    }
}
