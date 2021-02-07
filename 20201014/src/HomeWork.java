import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import javax.swing.tree.TreeNode;
import java.util.Scanner;

/*调式第一步
1.打断点
2.点那个甲壳虫3.F7单步执行
*/
public class HomeWork {
    //最大公约数(辗转相除法)
    public static int maxNumber(int a,int b){
        while(a % b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return b;
    }
    //最小公倍数(俩数乘积/最大公约数)
    public static int minNumber(int a,int b){
        return a*b/maxNumber(a,b);
    }
    //斐波那契
    public static int fib(int n) {
        int f1 = 1;
        int f2 = 1;
        int f3 = 1;
        for (int i = 3;i <= n;i++){
            f3 = f1+f2;
            f1 = f2;//确定新的f1,f2
            f2 = f3;
        }
        return f3;
    }
    //找单独数字
    public static int findNumber(int[] arr) {
        int ret = 0;
        for (int i = 0;i < 5;i++){
            ret ^= arr[i];
        }
        return ret;
    }
    //俩整数相加
    public static int addInt(int a,int b) {
        return a+b;
    }
    //俩小数相加
    public static double addDouble(double a,double b) {
        return a+b;
    }
    //重载1.方法名字相同  2.返回值类型不做要求 3.参数列表不同（数目或者类型）
    public static int add(int a,int b) {
        int ret = a+b;
        return ret;
    }
    public static double add(double a,double b) {//参数类型不同
        double ret = a+b;
        return ret;
    }
    public static double add(double a,double b,double c) { //参数数目不同
        double ret = a+b+c;
        return ret;
}
//最大值重载
    public static int max(int a,int b){
        if(a > b){
            return a;
        }else {
            return b;
        }
    }
    public static double max(double a,double b) {//参数类型不同
        if(a > b){
            return a;
        }else {
            return b;
        }
    }
    public static double max(double a,double b,int c) {
        double max=a;
        if(b > max){
            max = b;
        }
        if(c > max){
            max = c;
        }
        return max;
    }

    //调用自身的递归1.调用自身，2.有结束条件
    //阶乘
    public static int fac(int n) {
        if(n == 1){
            return 1;
        }
        int tmp = n * fac(n - 1);
        return tmp;
    }
    //递归按照顺序打印数字每一位
    public static void print(int n) {
        /*if (n > 9){
            print(n/10);
        }*/
        if(n<=9){
            System.out.println("顺序打印数字每一位:"+n);
            return;
        }
        print(n/10);
        System.out.println(n%10);
        //System.out.println("顺序打印数字每一位:"+n%10);
    }
    //递归求 1 + 2 + 3 + ... + 10
    public static int sum(int n) {
        //return x == 1?1:x+fun(x-1);
        if(n == 1){
            return 1;
        }
        return n + sum(n-1);
    }
//返回每一位加起来的和
    public static int print1(int n) {
        if(n<10){
            return n;
        }
        return print1(n/10)+n%10;
    }
    //递归斐波那契
    public static int fb(int n) {
        if(n==1||n==2){
            return 1;
        }
        return fb(n-1)+fb(n-2);
    }
    //青蛙跳台阶
    public static int climb(int i, int n) {
        //表示当前台阶数大于总台阶数，很显然这种情况不符合，走不通，记为 0
        if (i > n) {
            return 0;
        }
        //表示当前台阶数正好等于总的台阶数，那么这种情况符合，记为 1
        if (i == n) {
            return 1;
        }
        return climb(i + 1, n) + climb(i + 2, n);
    }
    //青蛙变态跳方法一
    public static int jumpFloorII(int n) {
        if (n==0 || n==1) return 1;
        int a = 1, b = 0;
        for (int i=2; i<=n; ++i) {
            b = a << 1; //  口诀：左移乘2，右移除2
            a = b;
        }
        return b;
    }
    //青蛙变态跳方法二
    /*你会发现一个规律：
f[0] = f[1]
f[2] = 2
f[3] = 4
f[4] = 8 */
    /*int jumpFloorII(int n) {
        if (n == 0 || n == 1) return 1;
        return static_cast(pow(2, n-1));
    }*/
    //汉诺塔
    /*1.A->C
    2.A->B,A->C,B->C
    3.A->C,A->B,C->B,A->C,B->A,B->C,A->C
    pos1第一个盘子，pos2中转盘子，pos3目标盘子
    */
    public static void move(char pos1,char pos2){
        System.out.print(pos1+"->"+pos2+" ");
    }
    public static void hnt(int n,char pos1,char pos2,char pos3){
        if(n==1){
            move(pos1,pos3);
            return;
        }
        hnt(n-1,pos1,pos3,pos2);//把pos1上前n-1个通过pos3移动到pos2
        move(pos1,pos3);
        hnt(n-1,pos2,pos1,pos3);

    }

        public static void main (String[]args){
            int[] array = {2, 5, 1, 2, 1};
            int r = findNumber(array);
            System.out.println("找到的单独数字是：" + r);
            System.out.println("斐波那契的第n项：" + fib(5));
            int a = 10, b = 20;
            System.out.println("俩整数和为：" + addInt(a, b));
            double c = 12.5, d = 13.4;
            System.out.println("俩小数和为：" + addDouble(a, b));
            //递归
            System.out.println("递归n的阶乘" + fac(5));
            print(1234);
            System.out.println("每一位加起来的和:" + print1(1234));
            System.out.println("前10项和：" + sum(10));
            System.out.println(fb(5));
            int ret = 0;
            for (int i = 0; i < 5; i++) {
                ret += array[i];
            }
            System.out.println("数组和为：" + ret);
            System.out.println(climb(0, 10));//青蛙跳
            //汉诺塔
            hnt(1,'A','B','C');
            System.out.println();
            hnt(2,'A','B','C');
            System.out.println();
            hnt(3,'A','B','C');
            System.out.println();
            //重载求最大值
            System.out.println("俩个整数最大:"+max(a,b));
            System.out.println("俩个小数最大:"+max(c,d));
            System.out.println("俩个小数和一个整数最大:"+max(c,d,a));
            System.out.println("最大公约数:"+maxNumber(18,24));
            System.out.println("最小公倍数:"+minNumber(18,24));
        }
    }
