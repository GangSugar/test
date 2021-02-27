import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            //1.首先得到俩个数组
            String str = scan.nextLine();
            char[] ch = str.toCharArray();

            String str1 = scan.nextLine();
            char[] ch1 = str1.toCharArray();
            //2.用来存放找到的珠子
            List list = new ArrayList();
            //3.遍历自己需要的珠子
            for (int i = 0;i < ch1.length;i++){
                for (int j = 0;j < ch.length;j++){
                    if (ch[j] == ch1[i]){
                        list.add(ch1[i]);
                        ch[j] = (char)-1;//将以及比较过的珠子标记一下
                        break;//找到直接跳出
                    }
                }
            }
            if (list.size() == ch1.length){
                int num = ch.length - list.size();
                System.out.println("Yes"+" "+num);
            }else {
                int num = ch1.length-list.size();
                System.out.println("No"+" "+num);
            }
        }
    }
}
