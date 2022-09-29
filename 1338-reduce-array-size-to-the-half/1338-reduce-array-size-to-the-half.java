class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            int key = arr[i];
            int size = map.getOrDefault(key, 0);
            map.put(key, size+1);
        }

        List<Integer> size = new ArrayList<>(map.values());
        size.sort((a, b) -> b-a);

        int ans = 0;
        int target = (n+1)/2;
        for(Integer s : size) {
            target -= s;
            ans++;
            if(target <= 0) break;
        }

        return ans;
    }
}