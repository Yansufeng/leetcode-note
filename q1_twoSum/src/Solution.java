import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Yansufeng
 * @Date 2021/10/29 8:04 下午
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int index = 0;
        int remain;
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        HashMap<Integer, Integer> hashmap = new HashMap<>();

        for(int value : numList) {
            remain = target - value;
            if(hashmap.containsKey(remain)) {
                return new int[]{hashmap.get(remain), index};
            }
            hashmap.put(value, index);
            index++;
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.twoSum(nums, target)));
    }
}
