class Solution {
    public int longestPalindrome(String str) {
                int[] t = new int[128];
        for(int i = 0; i < str.length(); i++) {
            t[str.charAt(i)]++;
        }

        // System.out.println(Arrays.toString(t));
        // int sum = 0, sumofeven = 0;
        // for(int i = 0; i < t.length; i++) {
        //     sum += t[i];
        //     if(t[i] != 0 && t[i]%2==1) {
        //         System.out.println((char)i + " appears " + t[i] + " times.");
        //     } else {
        //         sumofeven += t[i];
        //     }
        // }
        // System.out.println("sum: " + sum + " sumofeven: " + sumofeven);

        int len = 0;
        int maxmid = 0;
        for(int x : t) {
            if(x % 2 == 0) {
                len += x;
            }
            else { //if(x % 2 == 1)
                if (x > maxmid) {
                    len = len + x - maxmid;
                    len += maxmid / 2 * 2;
                    maxmid = x;
                }
                else {
                    len += x / 2 * 2;
                }
            }
        }
        return len;

    }
}