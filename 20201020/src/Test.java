//单向链表测试
public class Test {

    public static void main(String[] args) {
        MySingLinkled a = new MySingLinkled();
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(3);
        a.addFirst(4);
        a.display();
        a.addLast(8);
        a.addLast(7);
        a.addLast(6);
        a.addLast(5);
        a.display();
        a.addIndex(8,99);
        a.display();
        System.out.println(a.size());
        System.out.println(a.contains(3));
        a.remove(99);
        a.display();
        a.addIndex(6,99);
        a.addIndex(3,99);
        a.addIndex(5,99);
        a.display();
        a.removeAllKey1(99);
        a.display();
        //a.display1(a.reverseList());//反转单链表
        Node ret2 = a.middleNode();
        System.out.println(ret2.data);//打印中间节点a
        Node ret3 = a.findNode(7);
        System.out.println(ret3.data);
        Node ret4= a.partition(4);//打印左边小于x，右边大于x
        a.display1(ret4);

        Linked b = new Linked();
        b.addFirst(1);
        b.addFirst(2);
        b.addFirst(3);
        b.display();
        b.addLast(8);
        b.addLast(7);
        b.addLast(6);
        b.addLast(5);
        b.display();


    }
}
