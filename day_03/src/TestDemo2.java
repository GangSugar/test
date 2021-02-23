import java.util.Stack;

public class TestDemo2 {
    public static boolean chkParenthesis(String A, int n) {
        //需要一个栈
        Stack<Character> stack = new Stack<>();
        //遇到最大左括号就入栈，当遇到右边括号，就出栈，遇到其他字符直接false
        if(A.charAt(0) != '(' || A.length()%2 == 1)return false;
        else stack.push(A.charAt(0));
        for(int i = 1;i < A.length();i++){
            //System.out.println(A.charAt(i) );
            if(A.charAt(i) == '(' || A.charAt(i) == ')'){
                if(A.charAt(i) == '('){
                    stack.push(A.charAt(i));
                } else{
                    if(stack.empty()){
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }else{
                return false;
            }
        }
        if(stack.empty())
        return true;
        else return false;

    }

    public static void main(String[] args) {
        String str = "(()())";
        boolean k = chkParenthesis(str,6);
        System.out.println(k);
        //System.out.println('(' != ')');

        
    }
}
/*
* ()(()()
* (()())
* */