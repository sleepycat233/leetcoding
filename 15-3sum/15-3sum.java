class Solution {
    public List<List<Integer>> threeSum(int[] n) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(n);
        // System.out.println(Arrays.toString(n));

        for(int l = 0; l < n.length-2; l++) {
            if(l != 0 && n[l-1] == n[l]) {
                continue;
            }
            int r = n.length - 1;
            for(int m = l+1; m < r; m++) {
                if(m != l+1 && n[m-1] == n[m]) {
                    continue;
                }

                int target = -(n[l] + n[m]);
                while(r > m && n[r] > target) r--;
                if(m == r) break;

                if(n[r] == target) {
                    res.add(new ArrayList<>(Arrays.asList(n[l], n[m], n[r])));
                }
            }
        }

        return res;
    
    }
}