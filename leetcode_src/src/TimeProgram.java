import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class TimeProgram {
    static Map<Character, Character> m1 = new HashMap<>();

    private static boolean foo(char l) {
        switch (l) {
            case '(':
                // if (r == ')')
                    // return true;
                    l++;
                break;
            case '[':
                // if (r == ']')
                    // return true;
                    l++;
                break;
            case '{':
                // if (r == '}')
                    // return true;
                    l++;
                break;

            case 'a':
                l--;
                break;
            case 'b':
                l++;
                break;
            case 'c':
                l++;
                break;

            default:
                break;
        }
        return false;
    }

    public static void main(String[] args) {
        m1.put(')', '(');
        m1.put(']', '[');
        m1.put('}', '{');

        long start, end;
        Random r;

        start = System.currentTimeMillis();
        r = new Random();
        for(int i = 0; i < 100000000; i++) {
            int key = r.nextInt() % 1000;
            m1.get((char)key);
        }
        end = System.currentTimeMillis();
        long t1 = end - start;

        start = System.currentTimeMillis();
        r = new Random();
        for (int i = 0; i < 100000000; i++) {
            int key = r.nextInt() % 1000;
            foo((char) key);
        }
        end = System.currentTimeMillis();
        long t2 = end - start;

        System.out.println(t1);
        System.out.println(t2);
    }
}