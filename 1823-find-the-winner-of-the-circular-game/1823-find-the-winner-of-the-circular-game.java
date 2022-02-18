class Solution {
    public int findTheWinner(int n, int k) {
        Deque<Integer> d = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            d.add(i);
        }

        int count = 1;
        while(d.size() != 1) {
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
}