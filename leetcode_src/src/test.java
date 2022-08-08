import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class test {

    // treeSet test
    TreeSet<Integer> ts;
    public test() {
        ts = new TreeSet<>();
    }



    public static void main(String[] arg) {
        test obj = new test();
        List<Integer> ori = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int x = new Random().nextInt(100);
            ori.add(x);
            obj.ts.add(x);
        }
        System.out.println("ori: " + ori);
        System.out.println(obj.ts);
        System.out.println(obj.ts.ceiling(50));
        System.out.println(obj.ts.floor(50));
        System.out.println(obj.ts.lower(50));
        System.out.println(obj.ts.higher(50));

    }
}
