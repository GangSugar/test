import java.util.Stack;

//栈实现队列（俩个栈）https://leetcode-cn.com/problems/implement-queue-using-stacks/

/*
俩个栈实现队列
1.将值先入栈，一个用来入栈(s1)，另外一个是专门出的栈(s2)
2.s2只要不空，就可以直接弹出
3.s2为空了，检查s1是否为空，如果s1非空，则将s1的放到s2中，让s2为出
4.直到s1也为空了，则全部出完
 */
class MyQueue {
    private Stack<Integer> s1;//入栈
    private Stack<Integer> s2;//出栈
    /** Initialize your data structure here. */
    //构造方法
    public MyQueue(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    //入栈
    public void push(int x) {
        /*
        1.首先给s1入栈
         */
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        /*
        1.如果s2为空，则将s1全部的值先移动到s2
        2.如果s2有值，则直接弹出
         */
        if (s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        if (!s2.empty()){
            return s2.pop();
        }
        return -1;
    }

    /** Get the front element. */
    public int peek() {
        if (s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        if (!s2.empty()){
            return s2.peek();
        }
        return -1;

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (s1.empty() && s2.empty()){
            return true;
        }
        return false;
    }
}

public class TestDemo3 {
    public static void main(String[] args) {

    }
}
