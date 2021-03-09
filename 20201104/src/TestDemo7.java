

import java.util.ArrayList;
import java.util.Stack;

/*
栈的压入，弹出序列
https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&&tqId=11174&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
 */
class Solution3 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        /*
        新建一个栈，将数组A压入栈中，当栈顶元素等于数组B时，就将其出栈，
        当循环结束时，判断栈是否为空，若为空则返回true.
         */
        //定义一个栈
        Stack<Integer> stack = new Stack<>();
        int j = 0;//用来标识popA数组的下标
        //按照pushA的顺序开始入栈
        for (int i =0;i < pushA.length;i++){
            stack.push(pushA[i]);

            while(!stack.empty() && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.empty();//栈为空的时候说明全部遍历完毕；


    }
}

public class TestDemo7 {
    public static void main(String[] args) {

    }
}
