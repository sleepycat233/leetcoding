class Solution {
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
        return (index % n) + 1;    }
}