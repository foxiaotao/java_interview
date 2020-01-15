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

    /**
     * 循环 的方式反转
     * @param head
     * @return
     */
    public static Node reverse2(Node head) {
        // 原 前置node
        Node preNode = null;
        // 原来的next
        Node nextNode = null;
        // 1-2-3-4-5
        while (head != null) {
            nextNode = head.next;
            head.next = preNode;
            // 完成本轮交换

            // 赋值 下轮preNode
            preNode = head;

            // 循环到下一个
            head = nextNode;
        }
        return preNode;

    }



    /**
     * 反转链表 递归
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
