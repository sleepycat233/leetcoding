import java.util.*;
public class IntersectionTwoArrays {
    //sort + two pointer
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

    //stack
    public int[] intersect2(int[] nums1, int[] nums2) {
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
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

        // or instead
/*      if(nums1.length < nums2.length) {
            intersect(nums2, nums1);
        } */

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
                res[index++] = k;
                map.put(k, --v);
            }
        }

        return Arrays.copyOfRange(res, 0, index);
    }

    public static void main(String[] args) {
        IntersectionTwoArrays sol = new IntersectionTwoArrays();

        System.out.println(Arrays.toString(sol.intersect(new int[] {1, 2, 2, 1}, new int[] {2, 2})));
        System.out.println(Arrays.toString(sol.intersect2(new int[] {1, 2, 2, 1}, new int[] {2, 2})));
    }
}
