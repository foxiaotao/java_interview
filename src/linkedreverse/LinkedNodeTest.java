package linkedreverse;

/**
 * @description: test
 * @author:tao
 * @create: 2020-01-14 18:35
 */
public class LinkedNodeTest {

    private static final int n = 5;

    public static void main(String[] args) {

        Node node = getIndexNode(0);
        printlnNode(node);
        System.out.println();

        Node reverse = reverse2(node);

        printlnNode(reverse);

    }

    /**
     * 生成链表
     * @param i
     * @return
     */
    public static Node getIndexNode(int i) {
        Node node = new Node(i);
        if (i >= n) {
            return node;
        }
        Node nextLinkedNode = getIndexNode(++i);
        node.setNext(nextLinkedNode);
        return node;
    }

    public static Node reverse2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 记录当前node
        Node next = head.next;

        // 获取新的，新的节点
        Node last = reverse2(head.next);

        // 要断掉当前的next，把head.next.next 指向head
        next.next = head;
        head.next = null;

        // 返回 原来最后的 后一个node
        return last;

    }



    /**
     * 反转链表
     * @param head
     * @return
     */
    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head.next;
        Node newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }


    /**
     * 打印链表
     * @param node
     */
    public static void printlnNode(Node node) {
        System.out.println("链表[" + node.value + "]value=" + node.value);
        while (node.next != null) {
            printlnNode(node.next);
            return;
        }
        return;
    }


}
