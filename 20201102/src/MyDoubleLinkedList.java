

/*
泛型实现自己的双向链表
 */
public class MyDoubleLinkedList<E>{
    //一个数据域，俩个地址域，一个前驱，一个后继(静态节点类)
    public static class Node<E> {
        public E data;
        public Node<E> prev;
        public Node<E> next;
        //构造方法
        public Node(E e) {
            this.data = e;
        }
    }

    //设置head表示双向链表的头，last表示尾巴
    public Node<E> head;//永远指向头
    public Node<E> last;//永远指向尾巴

    // 头插
    public void pushFront(E e) {
        Node<E> node = new Node<>(e);
        //1.是不是第一次插入
        if(head == null){
            head = node;
            last = node;
            return;
        }
        //其他情况
        node.next = head;
        head.prev = node;
        head = node;
    }
    //尾插
    public void pushLast(E e) {
        Node<E> node = new Node<>(e);
        //1.是不是第一次插入
        if(head == null){
            head = node;
            last = node;
            return;
        }
        //其他情况
        last.next = node;
        node.prev = last;
        last = node;

    }
    //长度
    public int size(){
        Node<E> cur = this.head;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    //打印
    public void display(){
        //直接遍历
        Node<E> cur = this.head;
        while (cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

}


class TestDemo3{
    public static void main(String[] args) {
        MyDoubleLinkedList<Integer> myDoubleLinkedList = new MyDoubleLinkedList<>();
        myDoubleLinkedList.pushFront(1);
        myDoubleLinkedList.pushFront(2);
        myDoubleLinkedList.pushFront(3);
        myDoubleLinkedList.pushFront(4);
        myDoubleLinkedList.display();
        myDoubleLinkedList.pushLast(5);
        myDoubleLinkedList.pushLast(6);
        myDoubleLinkedList.pushLast(7);
        myDoubleLinkedList.display();
        System.out.println(myDoubleLinkedList.size());


    }
}
