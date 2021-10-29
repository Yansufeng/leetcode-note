import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Yansufeng
 * @Date 2021/10/29 8:09 下午
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1) return 1;

        /**
         * 将String转换为char[]后转换为List< Character>
         * 如果使用Arrays.asList会转换为List< char[]>
         */
        List<Character> input = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        HashMap windowMap = new HashMap<Character, Integer>();
        int max = 0, index = 0, indexStart = 0;
        char[] c = s.toCharArray();

        for(Iterator iter = input.iterator(); iter.hasNext();) {
            char item = (char) iter.next();

            if(windowMap.containsKey(item)) {
                int len = index - indexStart;
                max = max < len ? len : max;
                if(!iter.hasNext()) return max;

                int indexOld = (int) windowMap.get(item);
                for(int i = indexStart; i <= indexOld; i++) {
                    windowMap.remove(c[i]);
                }
                indexStart = indexOld + 1;
            } else {
                int len = index - indexStart + 1;
                max = max < len ? len : max;
            }
            windowMap.put(item, index);
            index++;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("auv"));
    }
}
