class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new LinkedHashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for(int n : nums1) {
            map.put(n, -1);
        }

        for(int i = nums2.length-1; i >= 0; i--) {
            int element = nums2[i];
            while(!stack.isEmpty()) {
                if(element >= stack.peek()) {
                    stack.pop();
                }
                else {
                    break;
                }
            }

            if(map.get(element) != null) {
                if(!stack.isEmpty()) {
                    map.put(element, stack.peek());
                }
            }

            stack.push(element);
        }

        return map.values().stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    
    }
}