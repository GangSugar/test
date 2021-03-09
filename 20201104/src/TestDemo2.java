import java.util.LinkedList;
import java.util.Queue;

//用队列实现栈（需要俩个队）
class MyStack {

    private Queue<Integer> qu1;
    private Queue<Integer> qu2;
    public int usedSize;


    /** Initialize your data structure here. */
    //构造方法
    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();

    }

    /** Push element x onto stack. */
    //入队
    public void push(int x) {
        //1、谁不为空  入到哪个队列就好了
        //2、两个都为空   放到第一个qu1当中
        if (!qu1.isEmpty()){
            qu1.offer(x);
        }else if (!qu2.isEmpty()){
            qu2.offer(x);
        } else {
            qu1.offer(x);
        }
        usedSize++;
    }

    /** Removes the element on top of the stack and returns that element. */
    //出队
    public int pop() {
        //1.先将前面size-1个移动到空的队列
        //2.将队列最后一个弹出，就是类似于出栈顺序
        //3.反复进行，直到俩个队列都为空的时候出队完毕
        if (empty()){//俩个队列都空
            return -1;
        }
        int size = usedSize;
        if (!qu1.isEmpty()){
            for (int i = 0; i < size-1; i++) {
                qu2.offer(qu1.poll());
            }
            usedSize--;
            return qu1.poll();
        }else{

            for (int i = 0; i < size-1; i++) {
                qu1.offer(qu2.poll());
            }
            usedSize--;
            return qu2.poll();
        }

    }

    /** Get the top element. */
    //弹栈顶
    public int top() {
        if (empty()){//俩个队列都空
            return -1;
        }
        int tmp = -1;
        int size = usedSize;
        if (!qu1.isEmpty()){
            for (int i = 0; i < size ; i++) {
                tmp = qu1.poll();
                qu2.offer(tmp);
            }
        }else{
            for (int i = 0; i < size; i++) {
                tmp = qu2.poll();
                qu1.offer(tmp);
            }
        }
        return tmp;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(qu1.isEmpty() && qu2.isEmpty()){
            return true;
        }
        return false;
    }
}


public class TestDemo2 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        System.out.println(myStack.top());
    }
}

