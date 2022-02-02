class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> res = new ArrayList<>();
        int p1 = 0, p2 = 0;

        while(p1 < nums1.length && p2 < nums2.length) {
            int n1 = nums1[p1];
            int n2 = nums2[p2];
            if(n1 < n2) {
                ++p1;
            }
            else if(n1 > n2) {
                ++p2;
            }
            else {
                res.add(n1);
                ++p1;
                ++p2;
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}