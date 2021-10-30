import java.util.Arrays;
import java.util.Stack;

/**
 * @Author Yansufeng
 * @Date 2021/10/30 8:08 下午
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        public void push(int val) {
            ListNode nodeNew = new ListNode(val);
            nodeNew.next = this.next;

            this.next = nodeNew;
        }
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode currNode = head;
        int len = 0;

        while(currNode != null) {
            stack.push(currNode.val);
            len ++;
            currNode = currNode.next;
        }

        int[] output = new int[len];

        for(int i = 0; i < len; i ++) {
            output[i] = stack.pop();
        }

        return output;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = new ListNode(1);
        head.next = null;
        head.push(2);
        head.push(3);

        System.out.println(Arrays.toString(s.reversePrint(head)));
    }
}
