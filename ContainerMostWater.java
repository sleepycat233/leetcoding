public class ContainerMostWater {
    //brute force, O(n^2)
    public int maxArea(int[] height) {
        int area, maxarea = 0;
        for(int i = 0; i < height.length; i++) {
            for(int j = height.length-1; j > i; j--) {  //这种制式可以换成双指针解法
                area = (j-i) * Math.min(height[i], height[j]);
                maxarea = Math.max(maxarea, area);
                if(height[j] >= height[i]) break;
            }
        }
        return maxarea;
    }

    //two pointer
    public int maxArea2(int[] height) {
        int i = 0, j = height.length-1;
        int area, maxarea = 0;
        int prevHeight;
        while(i < j) {
            area = (j - i) * Math.min(height[i], height[j]);
            maxarea = Math.max(maxarea, area);
            if(height[i] < height[j]) {
                prevHeight = height[i];
                while(height[i] <= prevHeight && i < j)
                    i++;
            }
            else {
                prevHeight = height[j];
                while(height[j] <= prevHeight && i < j)
                    j--;
            }
        }

        return maxarea;
    }

    public static void main(String[] args) {
        ContainerMostWater sol = new ContainerMostWater();
        System.out.println(sol.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(sol.maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
