import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleinHistogram {
    // picking the height then expand the width;
    public int largestRectangleArea1(int[] heights) {
        int maxArea = 0;
        for(int m = 0; m < heights.length; m++) {
            int l = m;
            int r = m;

            while (l-1 >= 0 && heights[l-1] >= heights[m]) {
                l--;
            }
            while (r+1 < heights.length && heights[r+1] >= heights[m]) {
                r++;
            }

            int currArea = (r - l + 1) * heights[m];
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }

    public int largestRectangleArea2(int[] heights) {
        int[] lbound = new int[heights.length];
        int[] rbound = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            lbound[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int j = heights.length - 1; j >= 0; j--) {
            while (!stack.isEmpty() && heights[j] <= heights[stack.peek()]) {
                stack.pop();
            }
            rbound[j] = (stack.isEmpty()) ? heights.length : stack.peek();
            stack.push(j);
        }

        int maxArea = 0;
        for(int k = 0; k < heights.length; k++) {
            int currArea = (rbound[k] - lbound[k] - 1) * heights[k];
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleinHistogram sol = new LargestRectangleinHistogram();
        System.out.println(sol.largestRectangleArea1(new int[]{2,1,5,6,2,3}));
        System.out.println(sol.largestRectangleArea2(new int[]{2,1,5,6,2,3}));
    }
}
