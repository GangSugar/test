import java.util.Objects;
import java.util.Stack;

//顺序（顺序表实现）栈
class MyStack<T> {
    public T[] elem;//数组
    public int usedSize;//top

    public MyStack() {
        this.elem = (T[])new Objects[5];
    }
    //入栈
    public void push(T item) {
        //满
        if(isFull()) {
            return;
        }
        this.elem[this.usedSize] = item;
        this.usedSize++;
    }
    //出栈
    public T pop() {
        //空
        if(isEmpty()) {
            //return -1;
            throw new RuntimeException("栈为空！");
        }
        T ret = this.elem[this.usedSize-1];
        this.usedSize--;
        this.elem[usedSize] = null;
        return ret;
    }
    //获取栈顶元素，但是不删除
    public T peek(){
        //空
        if(isEmpty()) {
            //return -1;
            throw new RuntimeException("栈为空！");
        }
        return this.elem[this.usedSize-1];
    }
    //判断是否为空
    public boolean isEmpty() {
        if(this.usedSize == 0) {
            return true;
        }
        return false;
        //return this.usedSize == 0;
    }
    //判断是否为满
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }
}


public class TestDemo2 {

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);//入栈
        myStack.push(12);
        myStack.push(3);

        System.out.println(myStack.pop());//3，出栈
        System.out.println(myStack.peek());//12，获取栈顶元素

    }


    public static void main1(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);
        System.out.println(stack);
        System.out.println("size:"+stack.size());
        int ret = stack.peek();//得到栈顶元素但是不删除
        System.out.println(ret);
        System.out.println(stack);
        System.out.println("size:"+stack.size());
       /* System.out.println("size:"+stack.size());
        int ret = stack.pop();//弹出
        System.out.println(ret);
        System.out.println(stack);
        System.out.println("size:"+stack.size());
*/
    }
}
