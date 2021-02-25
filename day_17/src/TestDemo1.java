import java.util.*;
public class TestDemo1 {
    static Stack<String> stack2 = new Stack<String>();
    static Stack<String> stack1 = new Stack<String>();
    static List<String> result = new ArrayList<>();//用来放结果的
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            scan.nextLine();
            String[] str = scan.nextLine().split(" ");
            //先放入s1栈
            for(int i = str.length-1;i >= 0;i--){
                stack1.push(str[i]);
            }
            //开始调用get方法
            get("");

            Collections.sort(result);
            for(String r : result){
                System.out.println(r);
            }
        }
    }

    public static void get(String s){
        //1.如果俩个栈都为空，直接返回
        if(stack1.empty()&&stack2.empty()){
            result.add(s.trim());//将s放入结果
            return ;
        }
        //2.如果s2非空
        if(!stack2.empty()){
            //弹出s2栈顶
            String str = stack2.pop();
            get(s+" "+str);
            stack2.push(str);
        }
        //3.如果s1非空
        if(!stack1.empty()){
            String str = stack1.pop();
            stack2.push(str);
            get(s);
            stack2.pop();
            stack1.push(str);
        }
    }
}


