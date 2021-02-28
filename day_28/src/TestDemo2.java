//牛客密码验证合格程序
import java.util.*;
public class TestDemo2{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String str = scan.nextLine();
            if(str.length()<=8) {//不超过8位的直接NG
                System.out.println("NG");
            }else {
                int a=0,b=0,c=0,d=0;//a：大写  b:小写  c：数字  d：其他符号
                //开始遍历字符串，进行验证
                for(int i=0;i<str.length();i++) {
                    if(str.charAt(i)>='A'&&str.charAt(i)<='Z') {
                        a=1;
                    }else if(str.charAt(i)>='a'&&str.charAt(i)<='z') {
                        b=1;
                    }else if(str.charAt(i)>='0'&&str.charAt(i)<='9') {
                        c=1;
                    }else {
                        d=1;
                    }
                    if(a+b+c+d>=3) {//满足第二个条件，可以提前跳出
                        break;
                    }
                }
                if(a+b+c+d<3) {//跳出来，需要判断，因为无法确定是怎么从for循环中出来
                    System.out.println("NG");
                }else {
                    boolean t = true;
                    for(int i=0;i<str.length()-3;i++) {
                        String str1 = str.substring(i,i+3);//截取的时候是左闭右开区间
                        String str2 = str.substring(i+3,str.length());
                        if(str2.contains(str1)) {//判断是否为子串关系
                            System.out.println("NG");
                            t = false;
                            break;
                        }
                    }
                    if(t) {
                        System.out.println("OK");
                    }
                }
            }
        }
    }
}