class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int[] circularArray = new int[nums.length*2];
        for(int i = 0; i < circularArray.length; i++) {
            circularArray[i] = nums[i%nums.length];
        }

        int[] res = new int[circularArray.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = circularArray.length-1; i >= 0; i--) {
            int element = circularArray[i];
            while(!stack.isEmpty() && element >= stack.peek()) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                res[i] = stack.peek();
            }
            else {
                res[i] = -1;
            }

            stack.push(element);
        }

        return Arrays.copyOf(res, nums.length);
    
    }
}