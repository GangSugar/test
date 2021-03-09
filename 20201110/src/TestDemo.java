import java.util.PriorityQueue;

public class TestDemo {


    public static void main(String[] args) {
        int[] arr = {27,15,19,18,28,34,65,49,25,37};
        MyHeap heap = new MyHeap();
        heap.initHeap(arr);
        /*heap.heapsort();*/
        heap.show();
        //System.out.println(heap.lastStoneWeight(arr));

    }


    public static void main1(String[] args) {
        //优先级队列(最下面实现方法是小根堆)，从小到大排列好的数据，
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.offer(13);
        priorityQueue.offer(3);
        priorityQueue.offer(8);
        priorityQueue.offer(49);

        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());
    }
}
