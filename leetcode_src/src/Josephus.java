import java.util.*;

public class Josephus {
    public int findTheWinner(int n, int k) {
        int[] a = new int[n];
        int dead = 0;
        int index = 0;
        int count = 1;
        while(dead < n) {
            while(count < k) {
                if (a[index % n] != 1) {
                    index++;
                    count++;
                }
                else {
                    index++;
                }
            }
            count = 1;
            while(a[index % n] == 1) index++;
            a[index%n] = 1;
            dead++;
        }
        return (index % n) + 1;
    }

    public int findTheWinner2(int n, int k) {
        Deque<Integer> d = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            d.add(i);
        }

        int count = 1;
        while(d.size() > 1) {
            if(count == k) {
                d.removeFirst();
                count = 1;
            }
            else {
                d.addLast(d.removeFirst());
                count++;
            }
        }
        return d.getFirst();
    }

    public static void main(String[] args) {
        Josephus sol = new Josephus();
        System.out.println(sol.findTheWinner2(5, 2));
        System.out.println(sol.findTheWinner2(13, 2));
    }

}
