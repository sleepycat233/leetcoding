import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        for (int i = nums2.length - 1; i >= 0; i--) {
            int element = nums2[i];
            while (!stack.isEmpty() && element >= stack.peek()) {
                stack.pop();
            }

            if (map.containsKey(element)) {
                int index = map.get(element);
                if (!stack.isEmpty())
                    res[index] = stack.peek();
                else
                    res[index] = -1;
            }

            stack.push(element);
        }

        // return map.values().stream()
        // .mapToInt(Integer::intValue)
        // .toArray();
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElementI sol = new NextGreaterElementI();

        int[] res = sol.nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 });
        System.out.println(Arrays.toString(res));
    }
}
