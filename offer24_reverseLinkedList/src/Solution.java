/**
 * @Author Yansufeng
 * @Date 2021/10/30 9:42 下午
 */
public class Solution {
    private ListNode headWhole;

    Solution() {
        headWhole = new ListNode(0);
    }

    public ListNode init() {
        ListNode node1 = new ListNode(1);

        node1.next = new ListNode(2);

        return node1;
    }

    public void print(ListNode head) {
        System.out.print('[');
        while(head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.print(']');
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode lastNode = getNext(headWhole, head);

        return headWhole.next;
    }

    private ListNode getNext(ListNode head, ListNode node) {
        if(node.next == null) {
            head.next = new ListNode(node.val);
            return head.next;
        }

        head = getNext(head, node.next);
        head.next = new ListNode(node.val);
        return head.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.print(s.reverseList(s.init()));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
