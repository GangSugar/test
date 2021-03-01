import java.util.*;
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String P=input.next();//应付价钱
        String A=input.next();//实付价钱
        //.split(String regex)将此字符串分割为给定的 regular expression的匹配
        String[] P1=P.split("\\.");
        String[] A1=A.split("\\.");
        //Integer.parseInt(String s)将字符串参数解析为带符号的十进制整数
        int sumP=(Integer.parseInt(P1[0])*17*19+Integer.parseInt(P1[1])*19+Integer.parseInt(P1[2]));
        int sumA=(Integer.parseInt(A1[0])*17*19+Integer.parseInt(A1[1])*19+Integer.parseInt(A1[2]));
        int R=sumA-sumP;
        int r1,r2,r3;
        r1=R/(17*29);//加隆数
        r2=(R-r1*17*29)/29;//银可西数
        r3=(R-(r1*17*29)-r2*29);//纳特数
        if(sumP<=sumA) {
            System.out.println(r1 + "." + r2 + "." + r3 );
        }else{
            //Math。abs(int a)返回的是a的绝对值
            System.out.println("-"+Math.abs(r1) + "." +"-"+Math.abs(r2) + "." +"-"+ Math.abs(r3));
        }
    }
}

//import java.util.*;
//public class Main {
//    public static void main (String[] args){
//        Scanner scan = new Scanner(System.in);
//        while(scan.hasNext()){
//            String p = scan.next();//应付的钱
//            String a = scan.next();//实际付的钱
//            String[] p1 = p.split("\\.");
//            String[] a1 = a.split("\\.");
//            //单位全是纳特
//            int pSum = (Integer.parseInt(p1[0])*17*19)+(Integer.parseInt(p1[1])*19)+Integer.parseInt(p1[2]);
//            int aSum = (Integer.parseInt(a1[0])*17*19)+(Integer.parseInt(a1[1])*19)+Integer.parseInt(a1[2]);
//            int m = aSum - pSum;
//            int m1,m2,m3;
//            m1 = m/(17*19);//加隆
//            m2 = (m - m1*17*19)/19;//银西可
//            m3 = (m - (m1*17*19) - (m2*19));//纳特
//            if(pSum <= aSum){//输出正数
//                System.out.println(m1+"."+m2+"."+m3);
//            }else{
//                System.out.println("-"+Math.abs(m1)+"."+Math.abs(m2)+"."+Math.abs(m3));
//            }
//        }
//    }
//}
