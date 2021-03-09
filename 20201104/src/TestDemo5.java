import java.util.Stack;

/*
逆波兰式计算:https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
/*
        整体思路
        1.拿一个栈，遇到运算数字就入栈，
        2.直达遇到预算符，就从栈中弹出俩个数字，先弹出的作为右操作数，下一个弹出是左边操作上去
          (因为栈的原理是先进后出，左操作数是先入栈，因此出栈的时候，他是后出的)
        3.将弹出的俩个操作数进行运算后得到的结果，将这个结果还要继续入栈
        4.就这样不断入栈 ————》 出栈 ————》 计算 ————》 入栈，一直到遍历完输入，
          最后栈剩余的那个运算数就是逆波兰式子的最终于结果
        */
class Solution2{
    public Stack<Integer> stack;
    //构造方法
    public Solution2(){
        stack = new Stack<>();
    }

    public int evalRPN(String[] tokens) {
        int left,right;//left放左操作数，right放右操作数
        //依次遍历逆波兰式字符串，数字进栈，运算符，从栈中弹俩次
        for(int i = 0;i < tokens.length;i++){
            String str = tokens[i];

            //按照*/+-的优先级顺序
            if (str.equals("*")){
                right = stack.pop();
                left = stack.pop();
                stack.push(left * right);//新运算数入栈
            }else if (str.equals("/")){
                right = stack.pop();
                left = stack.pop();
                stack.push(left / right);//新操作数入栈
            }else if (str.equals("+")){
                right = stack.pop();
                left = stack.pop();
                stack.push(left + right);//新操作数入栈
            }else if (str.equals("-")){
                right = stack.pop();
                left = stack.pop();
                stack.push(left - right);//新操作数入栈
            }else{
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }

}



public class TestDemo5 {
}
