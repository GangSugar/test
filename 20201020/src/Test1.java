//双向链表测试
public class Test1 {
    public static void main(String[] args) {
        DoubleLinkedList a = new DoubleLinkedList();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        a.addLast(4);
        a.addIndex(0,9);
        a.addFirst(88);
        a.display();
    }
}
