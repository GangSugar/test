import java.util.Stack;
/*
括号匹配问题(用栈来解决)https://leetcode-cn.com/problems/valid-parentheses/
*/
class Solution {
    public static boolean isValid(String s) {
        //思路:遇到左括号就入栈，遇到右括号进行匹配，匹配成功，弹出栈顶
        //一直匹配到栈中没有元素，才算成功
        Stack<Character> stack = new Stack<>();
        //只要再以下过程当中 发现不匹配  直接return false;
        for (int i = 0; i < s.length(); i++) {
            //1、左括号进行入栈
            char tmp = s.charAt(i);
            if(tmp == '(' || tmp == '[' || tmp == '{') {
                stack.push(tmp);
            } else{
                //2、判断栈是否为空
                if(stack.empty()) {
                    System.out.println("左括号多!");
                    return false;
                } else{
                    //3、判断栈顶元素的字符左括号和当前的字符 右括号是否匹配
                    char cur = s.charAt(i);//当前字符
                    char topChar = stack.peek();//栈顶元素
                    if(cur == ')' && topChar == '(' ||cur == ']' && topChar == '[' || cur == '}' && topChar == '{') {
                        stack.pop();
                    } else {
                        System.out.println("右括号不匹配左边括号");
                        return  false;
                    }
                }
            }
            }
        //4、判断栈是否为空
        if (!stack.isEmpty()){
            System.out.println("左括号多");
            return false;
        }
        System.out.println("括号匹配");
        return true;
        }

    }


public class TestDemo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("(())"));
        System.out.println(solution.isValid("({})"));
        System.out.println(solution.isValid("([])"));
        System.out.println(solution.isValid("(()))"));
        System.out.println(solution.isValid("((())"));
        System.out.println(solution.isValid("({)}"));
    }
}
