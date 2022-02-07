import java.util.*;

public class NextGreaterElement {
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

            if (map.containsKey(nums2[j])) {
                int pos = map.get(nums2[j]);
                res[pos] = (stack.isEmpty()) ? -1 : stack.peek();
            }
            stack.push(nums2[j]);
        }

        return res;
    }

    public static void main(String[] args) {
        NextGreaterElement sol = new NextGreaterElement();
        int[] n1 = new int[]{4,1,2};
        int[] n2 = new int[]{1,3,4,2};

        System.out.println(Arrays.toString(sol.nextGreaterElement(n1, n2)));
    }
}
