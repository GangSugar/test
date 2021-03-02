import java.util.Scanner;


public class TestDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x0 = sc.nextInt();
        int y0 = sc.nextInt();
        int z0 = sc.nextInt();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int z1 = sc.nextInt();

        //sqrt:根号 Math.pow(底数,几次方)
        double R = Math.sqrt(Math.pow( x0- x1,2) + Math.pow(y0 - y1,2) + Math.pow(z0- z1,2));
        double V = (4/3.0) *Math.acos(-1) * Math.pow(R,3);
        //球的体积：（4/3）* PI *r^3   Math.acos() 返回一个数的反余弦值
        //Math.acos(-1)的值为3.141592653589793

        //System.out.println(new DecimalFormat("0.000").format(R));
        //取R的一位整数三位小数，小数点前只有一个0，小数点后有 3个0
        //1 和 2 表达的意思是一样的
        /*DecimalFormat format = new DecimalFormat("0.000");
        System.out.println(format.format(R) + " " + format.format(V));*/
        //2
        //System.out.println(new DecimalFormat("0.000").format(R) + " " + new DecimalFormat("0.000").format(V));
        System.out.printf("%.3f",R);
        System.out.printf(" ");
        System.out.printf("%.3f",V);
    }
}

