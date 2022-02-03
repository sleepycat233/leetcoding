class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] hash, search;
        if(nums1.length < nums2.length) {
            hash = nums1;
            search = nums2;
        }
        else {
            hash = nums2;
            search = nums1;
        }

        for(int i = 0; i < hash.length; i++) {
            int k = hash[i];
            if(!map.containsKey(k)) {
                map.put(k, 1);
            }
            else {
                int v = map.get(k);
                map.put(k, ++v);
            }
        }

        for(int j = 0; j < search.length; j++) {
            int k = search[j], v;
            if(map.containsKey(k) && (v = map.get(k)) > 0) {
                res.add(k);
                map.put(k, --v);
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}