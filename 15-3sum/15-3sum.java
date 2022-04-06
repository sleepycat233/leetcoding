class Solution {
    public List<List<Integer>> threeSum(int[] n) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(n);
        System.out.println(Arrays.toString(n));

        for(int i = 0; i < n.length-2; i++) {
            if(i == 0 || n[i-1] != n[i]) {
                // for (int k = n.length - 1; k > i+1; k--) {
                int k = n.length - 1;
                int j = i+1;

                while(j < k) {
                    while(k != n.length-1 && n[k+1] == n[k] && k > j) {
                        k--;
                    }
                    if(j >= k) break;

                    int theone = -(n[i] + n[k]);
                    if(n[j] == theone) {
                        res.add(new ArrayList<>(Arrays.asList(n[i], n[j], n[k])));
                        j++;
                        k--;
                    }
                    else if(n[j] < theone) {
                        j++;
                    }
                    else {
                        k--;
                    }
                }
            }
        }

        return res;
    }
}