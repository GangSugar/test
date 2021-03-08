
/*
泛型
class MyArrayList<T>,T表示占位符

意义
1.可以自动进行类型检查
2.可以自动进行类型转换

坑’
1.不能够new泛型类型的数组 new T[10]
2.MyArrayList<Integer> myArrayList1 = new MyArrayList();//<>这里面不能是int这种简单类型
3.泛型类型的参数，不参与类型的组成
 */
class MyArrayList<T>{
    public T[] elem;
    public int usedSize;

    public MyArrayList() {
        this.elem = (T[])new Object[10];
    }

    public void add(T data){
        this.elem[usedSize++] = data;
    }
    public T getPos(int pos){
        return this.elem[pos];
    }
}

class MyLinkedList<E> {
    public static class Node<E> {
    private E value;
    private Node<E> next;
    private Node(E e) {
       value = e;
    }
}

   private Node<E> head;
   private int size;
   public MyLinkedList() {
       head = null;
       size = 0;
}

    // 头插
    public void pushFront(E e) {
        Node<E> node = new Node<>(e);
        node.next = head;
        head = node;
        size++;
}

    // 尾插
    public void pushBack(E e) {
         if (size == 0) {
             pushFront(e);
             return;
         }

    Node<E> cur = head;
    while (cur.next != null) {
        cur = cur.next;
     }

      cur.next = new Node<E>(e);
      size++;
   }
}

public class Test {
    public static void main(String[] args) {
        //<>用来指定要放数据的类型
        MyArrayList<String> myArrayList = new MyArrayList();
        myArrayList.add("hello");
        myArrayList.add("word");

        MyArrayList<Integer> myArrayList1 = new MyArrayList();
        myArrayList1.add(1);
        myArrayList1.add(2);
    }
}
