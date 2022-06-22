public class test {
    // non-tail recursion
    public static int count(String str) {
        if(str.isEmpty()) return 0;
        else return 1 + count(str.substring(1));
    }

    // tail recursion
    public static int count_tailrecursion(String str, int len) {
        if(str.isEmpty()) return len;
        else return count_tailrecursion(str.substring(1), len+1);
    }

    public static void main(String[] arg) {

        System.out.println(test.count("1234"));
        System.out.println(test.count_tailrecursion("1234", 0));
    }
}
