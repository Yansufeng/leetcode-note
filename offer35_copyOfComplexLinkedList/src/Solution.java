import java.util.HashMap;

/**
 * @Author Yansufeng
 * @Date 2021/10/30 8:32 下午
 */
public class Solution {
    private final HashMap<Node, Node> hash;

    public Solution() {
        hash = new HashMap<>();
    }

    public Node init() {
        Node head = new Node(1);
        Node next = new Node(2);

        head.next = next;
        head.random = next;
        next.next = null;
        next.random = next;

        return head;
    }

    public void printList(Node head) {
        System.out.print('[');
        while(head != null) {
            System.out.print("[" + head.val + ',' + head.random.val + ']');
            head = head.next;
        }
        System.out.print(']');
    }

    public Node copyRandomList(Node head) {
        create(head);

        return hash.get(head);
    }

    private void create(Node node) {
        if(hash.containsKey(node))
            return;

        if(node == null) {
            hash.put(null, null);
            return;
        }

        Node nodeNew = new Node(node.val);
        hash.put(node, nodeNew);

        create(node.next);
        nodeNew.next = hash.get(node.next);
        create(node.random);
        nodeNew.random = hash.get(node.random);

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.printList(s.copyRandomList(s.init()));
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
