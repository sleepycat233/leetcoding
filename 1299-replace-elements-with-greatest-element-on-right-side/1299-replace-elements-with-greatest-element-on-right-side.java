class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        int[] res = new int[arr.length];
        for(int i = arr.length-1; i >= 0; i--) {
            res[i] = max;
            max = Math.max(max, arr[i]);
        }
        
        return res;
    }
}