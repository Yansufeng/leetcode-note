import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author Yansufeng
 * @Date 2021/10/29 8:05 下午
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode init(ArrayList<Integer> input) {
        ListNode result, nodeNow, nodeNew;

        result = new ListNode();
        nodeNow = result;

        for (Integer value : input) {
            nodeNew = new ListNode(value);
            nodeNow.next = nodeNew;
            nodeNow = nodeNow.next;
        }

        return result.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result, nodeNow, nodeNew;
        result = new ListNode();
        nodeNow = result;

        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            nodeNew = new ListNode(sum >= 10 ? sum - 10 : sum);
            nodeNow.next = nodeNew;
            nodeNow = nodeNow.next;

            carry = sum >= 10 ? 1 : 0;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode lRemain = l1 != null ? l1 : l2;
        if(carry == 0) {
            nodeNow.next = lRemain;
            return result.next;
        }

        while(lRemain != null) {
            int sum = lRemain.val + carry;
            nodeNew = new ListNode(sum >= 10 ? sum - 10 : sum);
            nodeNow.next = nodeNew;
            nodeNow = nodeNow.next;

            carry = sum >= 10 ? 1 : 0;

            lRemain = lRemain.next;
        }

        if(carry == 0) return result.next;

        nodeNew = new ListNode(1);
        nodeNow.next = nodeNew;

        return result.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        //测试
        ArrayList input1 = new ArrayList(Arrays.asList(2, 4, 3));
        ArrayList input2 = new ArrayList(Arrays.asList(5, 6, 4));

        ListNode l1 = s.init(input1);
        ListNode l2 = s.init(input2);

        ListNode result = s.addTwoNumbers(l1, l2);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
