class Solution {
    public int threeSumMulti(int[] arr, int target) {

        int MOD = 1_000_000_007;
        int ans = 0;

        Arrays.sort(arr);
        for(int i = 0; i < arr.length-2; i++) {
            int T = target - arr[i];
            int j = i+1;
            int k = arr.length-1;

            while(j < k) {
                int sum = arr[j] + arr[k];

                if(sum < T) {
                    j++;
                }
                else if(sum > T) {
                    k--;
                }
                else if(arr[j] != arr[k]) {
                    int left = 1, right = 1;

                    while(j < k && arr[j+1] == arr[j]) {
                        j++;
                        left++;
                    }
                    while (j < k && arr[k-1] == arr[k]) {
                        k--;
                        right++;
                    }

                    ans += left * right;
                    ans %= MOD;
                    j++;
                    k--;
                }
                else {
                    ans += (k-j+1) * (k-j) / 2;
                    ans %= MOD;
                    break;
                }
            }
        }

        return ans;
    
    }
}