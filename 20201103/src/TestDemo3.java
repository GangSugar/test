import java.util.LinkedList;
import java.util.Queue;

//顺序栈 +  链式队列
class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
//链式（单链表）队列
class MyQueue {
    public Node head;//头
    public Node tail;//尾
    //添加（入队）
    public void offer(int val) {
        Node node = new Node(val);
        if(this.head == null) {
            this.head = node;
            this.tail = node;
            return;
        }
        this.tail.next = node;
        this.tail = node;
    }
    //出队
    public int poll() {
        if(this.head == null) {
            throw new RuntimeException("队列为空\n");
        }
        int oldData = this.head.val;
        if(this.head.next == null) {
            this.head = null;
            this.tail = null;
        }else {
            this.head = this.head.next;
        }
        return oldData;
    }
    //获取队头元素但是不删除
    public int peek() {
        if(this.head == null) {
            throw new RuntimeException("队列为空\n");
        }
        return this.head.val;
    }
    //判断是否为空
    public boolean isEmpty() {
        if(this.head == null) {
            return true;
        }
        return false;
    }

}


public class TestDemo3 {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);//入队
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        System.out.println(myQueue.peek());//获取队头元素
        System.out.println(myQueue.poll());//出栈
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());

    }
    public static void main1(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
       /* queue.add(1);
        queue.add(2);
        queue.add(3);*/
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        //弹出
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.isEmpty());
    }
}

