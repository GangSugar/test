
/*
比较含退格的字符串
https://leetcode-cn.com/problems/backspace-string-compare/
 */

import java.util.Stack;

/*
给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
注意：如果对空文本输入退格字符，文本继续为空

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/backspace-string-compare
 */
class Solution6 {
    public boolean backspaceCompare(String S, String T) {
        Stack<String> stack = new Stack<>();
        Stack<String> ttack = new Stack<>();
        //分别遍历俩个字符串
        for (int i =0;i < S.length();i++){
            String ch  = S.charAt(i)+"";
            if (ch.equals("#")){
                if (!stack.empty()){
                    stack.pop();
                }
            }else{
                stack.push(ch);
            }
        }
        for (int j =0;j < T.length();j++){
            String ch  = T.charAt(j)+"";
            if (ch.equals("#")){
                if (!ttack.empty()){
                    ttack.pop();
                }
            }else{
                ttack.push(ch);
            }
        }
        if (stack.empty()&&ttack.empty()){
            return true;
        }
        if (!stack.empty()&&ttack.empty()){
            return false;
        }
        if (stack.empty()&&!ttack.empty()){
            return false;
        }
        while (!stack.empty()&&!ttack.empty()){
            if(!stack.pop().equals(ttack.pop())){
                return false;
            }

        }
        if(stack.empty()&&ttack.empty()){
            return true;
        }
        return false;


    }
}
public class LeetCod844 {
    public static void main(String[] args) {
        String str = "abc";
        for (int i =0;i < str.length();i++){
            char ch  = str.charAt(i);
            System.out.print(ch);
        }
    }
}
