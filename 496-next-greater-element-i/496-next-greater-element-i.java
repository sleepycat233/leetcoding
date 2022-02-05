class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        for(int j = nums2.length-1; j >= 0; j--) {
            while(!stack.isEmpty() && nums2[j] >= stack.peek()) {
                stack.pop();
            }

            if(map.containsKey(nums2[j])) {
                int pos = map.get(nums2[j]);
                res[pos] = (stack.isEmpty()) ? -1 : stack.peek();
            }
            stack.push(nums2[j]);
        }

        return res;
    }
}