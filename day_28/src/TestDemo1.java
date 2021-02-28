//牛客守行数
import java.util.*;
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            int n =scan.nextInt();
            if(n < 2 || n >= 100){
                return;
            }
            num(n);
        }
    }
    //求守行数
    public static void num(int n){
        String str =String.valueOf(n);
        int str1 = n*n;
        String str2 =String.valueOf(str1);
        //取平方后字符串的地位与原数字字符串进行对比（从第二个数字取然后进行比较）
        if(str2.substring(1,str2.length()).equals(str)){
            System.out.println("YES!");
        }else {
            System.out.println("NO!");
        }
    }
}
