import java.lang.reflect.Array;
import java.util.*;

//计算前k个最小的数据，应该构造大根堆；
public class TopK {
    public static void topK(int[] arr, int k) {
        //取前5个最小的元素
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if(maxHeap.size() < k){
                maxHeap.offer(arr[i]);
            }else{
             if(arr[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }}
        }
        System.out.println(maxHeap);
    }

    public static void main(String[] args) {
        int[] arr = {12, 45, 2, 7, 10, 8, 19, 56, 32};
        topK(arr, 5);

    }

    /*//topk——前最大的k个数
    public static void getLeastNumbers(int[] arr, int k) {
        //建造大根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            //重写
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        //进入优先队列，进入前k个
        for(int i = 0;i < k;i++){
            maxHeap.offer(arr[i]);
        }
        //开始将后面的元素，如果小于堆顶就将堆顶弹出来，然后入堆
        for(int i = k;i < arr.length;i++){
            if (arr[i] > maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        System.out.println(maxHeap);
    }*/

    /*
    移除k位数字https://leetcode-cn.com/problems/remove-k-digits/
    * */
    public static String removeKdigits(String num, int k) {
        //使用一个栈
        Stack<Character> stack = new Stack<>();
        stack.push(num.charAt(0));
        //开始遍历
        int len = num.length();
        int tmp = len-k;//剩余的数据
        for (int i = 1;i < len;i++){
            char ch = num.charAt(i);
            if(!stack.empty() && k > 0){
                while(ch < stack.peek()){
                    stack.pop();
                    k--;
                }
            }
            stack.push(ch);
        }
        while(!stack.empty() && k > 0){
            stack.pop();
            k--;
        }
        //开始从栈中取出数据
        Stack<Character> stack1 = new Stack<>();
        for (int i = tmp;i > 0;i--){
            stack1.push(stack.pop());
        }
        String str = "";
        for(int i = tmp;i > 0;i--){
            str = str+stack1.pop();
        }
        return str;
    }
}