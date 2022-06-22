import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int[] height = new int[matrix[0].length];
        int maxArea = 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                height[j] = (matrix[i][j] == '0') ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxArea, countRecFromHeight(height));
        }

        return maxArea;
    }

    private int countRecFromHeight(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for(int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = (stack.isEmpty()) ? -1 : stack.peek();
                int currArea = height[j] * (i - k - 1);
                maxArea = Math.max(maxArea, currArea);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int j = stack.pop();
            int k = (stack.isEmpty()) ? -1 : stack.peek();
            int currArea = height[j] * (-1 - k - 1);
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        MaximalRectangle sol = new MaximalRectangle();
        char[][] m = new char[][]{{'1','0','1','0','0'},
                                {'1','0','1','1','1'},
                                {'1','1','1','1','1'},
                                {'1','0','0','1','0'}};

        System.out.println(sol.maximalRectangle(m));
    }
}
