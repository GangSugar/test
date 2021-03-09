
/*
棒球比赛
https://leetcode-cn.com/problems/baseball-game/
 */

import java.util.Stack;

/*
整数 x - 表示本回合新获得分数 x
"+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
"D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
"C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/baseball-game
 */
class Solution4 {
    public int calPoints(String[] ops) {
        int a = 0,b = 0,c =0,result = 0;
        //用栈，最后把栈中的元素变为整型，然后相加
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < ops.length;i++){
            if (ops[i].equals("+") ){
                a = stack.pop();
                b = stack.peek();
                c = a+b;
                stack.push(a);
                stack.push(c);
            }else if(ops[i].equals("D")){
                stack.push(2 * stack.peek());
            }else if (ops[i].equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.valueOf(ops[i]));
            }
        }
        while (!stack.empty()){

            result += stack.pop();
        }
        return result;
    }
}

public class LeetCod628 {
    public static void main(String[] args) {
        String[] o = {"5","2","C","D","+"};
        Solution4 s = new Solution4();
        System.out.println(s.calPoints(o));
    }
}
