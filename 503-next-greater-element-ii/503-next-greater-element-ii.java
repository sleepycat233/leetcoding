class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = nums.length * 2 - 1; i >= 0; i--) {
            int element = nums[i % nums.length];
            while(!stack.isEmpty() && element >= stack.peek()) {
                stack.pop();
            }

            res[i % nums.length] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(element);
        }

        return res;
    }
}