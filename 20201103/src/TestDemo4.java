
//循环队列（用数组实现）
class MyCircularQueue {
    public int[] elem;
    public int front;//队头
    public int rear;//队尾

    /** Initialize your data structure here. Set the size of the queue to be k. */
    //构造方法
    public MyCircularQueue(int k) {
        this.elem = new int[k+1];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    //入队
    public boolean enQueue(int value) {
        //1.先判断是否为满
        if(isFull()){
            return false;
        }
        this.elem[rear] = value;
        rear = (rear+1)%this.elem.length;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    //出队
    public boolean deQueue() {
        //1.判断是否为空
        if(isEmpty()){
            return false;
        }
        front = (front+1)%elem.length;
        return true;
    }

    /** Get the front item from the queue. */
    //获取队头元素
    public int Front() {
        //1.判断是否为空
        if(isEmpty()){
            return -1;
        }
        return elem[front];
    }

    /** Get the last item from the queue. */
    //获取队尾
    public int Rear() {
        //1.判断是否为空
        if(isEmpty()){
            return -1;
        }
        int index = this.rear==0 ? this.elem.length-1 :  this.rear-1;
        return elem[index];
    }

    /** Checks whether the circular queue is empty or not. */
    //是否为空
    public boolean isEmpty() {
        if(rear == front){
            return true;
        }
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    //是否为满
    public boolean isFull() {
        if((rear+1)%elem.length == front){
            return true;
        }
        return false;
    }
}

public class TestDemo4 {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(8);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(4);
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.Rear());
    }
}
