import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author Yansufeng
 * @Date 2021/10/29 8:11 下午
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        HashMap<String, int[]> numsMap = new HashMap<String, int[]>();
        boolean isOdd = sum % 2 != 0;
        int mid = isOdd ? sum / 2 + 1 : sum / 2;
        int midOfMid = mid / 2 - 1;

        numsMap.put("short", nums1.length > nums2.length ? nums2 : nums1);
        numsMap.put("long", nums1.length > nums2.length ? nums1 : nums2);

        while(mid > 1) {
            if(numsMap.get("short").length < 1) {
                if(isOdd) return numsMap.get("long")[mid - 1];
                else return (double) (numsMap.get("long")[mid - 1] + numsMap.get("long")[mid]) / 2;
            }

            int shortMid = 0, longMid = 0;
            if(midOfMid > numsMap.get("short").length - 1) {
                int len = numsMap.get("short").length;

                shortMid = len - 1;
                longMid = mid - len - 1;
            } else {
                longMid = shortMid = midOfMid;
            }

            int[] target;
            String targetKey;
            int targetLen;

            if(numsMap.get("short")[shortMid] < numsMap.get("long")[longMid]) {
                target = numsMap.get("short");
                targetKey = "short";
                targetLen = shortMid;
            }
            else {
                target = numsMap.get("long");
                targetKey = "long";
                targetLen = longMid;
            }

            int[] targetValue = arraySlice(target, targetLen + 1, target.length - 1);

            numsMap.put(targetKey, targetValue);
            mid -= targetLen + 1;

            midOfMid = mid / 2 - 1;
            mapSort(numsMap);
        }

        int[] longlist = numsMap.get("long");
        int[] shortlist = numsMap.get("short");

        if(isOdd) {
            if(shortlist.length > 0) return Math.min(longlist[0], shortlist[0]);
            else return longlist[0];
        } else {
            int num1;
            int num2;

            if(shortlist.length > 0) {
                num1 = Math.min(longlist[0], shortlist[0]);

                if(shortlist.length > 1 && longlist.length > 1) num2 = longlist[0] < shortlist[0] ? Math.min(longlist[1], shortlist[0]) : Math.min(longlist[0], shortlist[1]);
                else if(longlist.length > 1) num2 = longlist[0] < shortlist[0] ? Math.min(longlist[1], shortlist[0]) : Math.min(longlist[0], longlist[1]);
                else num2 = Math.max(longlist[0], shortlist[0]);
            } else {
                num1 = longlist[0];
                num2 = longlist[1];
            }

            return (double) (num1 + num2) / 2;
        }
    }

    public void mapSort(HashMap<String, int[]> map) {
        if(map.get("long").length > map.get("short").length) return;

        int[] t = map.get("long").clone();
        map.put("long", map.get("short"));
        map.put("short", t);
    }

    public int[] arraySlice(int[] input, int start, int end) {
        if(input.length <= end) {
            return null;
        }

        ArrayList<Integer> resultList = new ArrayList<>();

        for(int i = start; i <= end; i++) resultList.add(input[i]);

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[]{1};
        int[] b = new int[]{2, 3, 4, 5};

        double result = s.findMedianSortedArrays(a, b);

        System.out.println(result);
    }
}
