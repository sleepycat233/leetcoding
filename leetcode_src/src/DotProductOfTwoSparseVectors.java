import java.util.HashMap;
import java.util.Map;

public class DotProductOfTwoSparseVectors {
    class SparseVector {
        Map<Integer, Integer> values = new HashMap<>();
        int n;

        SparseVector(int[] nums) {
            n = nums.length;
            for(int i = 0; i < n; i++) {
                if(nums[i] != 0) {
                    values.put(i, nums[i]);
                }
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int ans = 0;

            if(this.n != vec.n) return -1;

            for(int i = 0; i < n; i++) {
                if(this.values.containsKey(i) && vec.values.containsKey(i)) {
                    ans += this.values.get(i) * vec.values.get(i);
                }
            }

            return ans;
        }
    }

}
