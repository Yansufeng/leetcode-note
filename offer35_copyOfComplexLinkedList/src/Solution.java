/**
 * @Author Yansufeng
 * @Date 2021/10/30 8:32 下午
 */
public class Solution {
    public Node copyRandomList(Node head) {
        return new Node(0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
