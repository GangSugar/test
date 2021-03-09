import java.util.Stack;
/*
最小数据栈的实现（栈中放的是另外一个栈中最小值）https://leetcode-cn.com/problems/min-stack/
 */
//采用辅助栈的形式
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    //入栈
    public void push(int x) {
        //1、stack是一定需要放元素的
        //2、最小栈当中 是否存放数据   x<= 最小栈的栈顶元素
        stack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);}
        else if(x <= minStack.peek()){
            minStack.push(x);
        }
    }
    //出栈
    public void pop() {
        //1、stack是一定需要弹出元素的
        //2、最小栈当中 是否弹出数据    x  ==  最小栈的栈顶元素
        int x = stack.pop();
        if(x == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        //跟最小栈没有关系
        return stack.peek();
    }

    public int getMin() {
        //每次返回最小栈的栈顶元素
        return minStack.peek();
    }
}
public class TestDemo4 {
    public static void main(String[] args) {

    }
}
