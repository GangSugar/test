//带傀儡节点的双向链表的测试类
public class Test2 {
    public static void main(String[] args) {
        DoubleList a = new DoubleList();
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(3);
        a.addFirst(4);
        a.display();
        a.addLast(5);
        a.addLast(6);
        a.addLast(7);
        a.display();
        System.out.println(a.size());
    }
}
