import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElementII {
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

    public static void main(String[] args) {
        NextGreaterElementII sol = new NextGreaterElementII();
        int[] res = sol.nextGreaterElements(new int[]{1,2,3,4,3});

        System.out.println(Arrays.toString(res));
    }
}
