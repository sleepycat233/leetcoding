public class ReverseString {
    public static String reverse(String str) {
        if(str.length() == 0) return "";
        else return reverse(str.substring(1, str.length())) + str.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(ReverseString.reverse("abc"));
    }
}
