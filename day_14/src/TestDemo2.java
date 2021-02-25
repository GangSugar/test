import java.util.*;
public class TestDemo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            GetSequeOddNum(n);
        }
    }
    public static String GetSequeOddNum(int m) {
        int num = (int)Math.pow(m,2)-m+1;//第一个数
        StringBuffer res = new StringBuffer();
        res.append(String.valueOf(num));
        for(int i = 1;i < m;i++){//m是几，就是几个数字相加
            num += 2;
            res.append("+");
            res.append(String.valueOf(num));
        }
        System.out.println(res.toString());
        return null;
    }
}


