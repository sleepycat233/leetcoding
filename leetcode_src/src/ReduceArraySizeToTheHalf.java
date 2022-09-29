import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReduceArraySizeToTheHalf {
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

    public static void main(String[] args) {
        ReduceArraySizeToTheHalf sol = new ReduceArraySizeToTheHalf();

        System.out.println(sol.minSetSize(new int[]{3,3,3,3,4,5,2,2,7}));
    }
}
