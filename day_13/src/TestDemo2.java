import java.math.BigInteger;
import java.util.Scanner;

public class TestDemo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String add = scan.nextLine();//加数
            String aug = scan.nextLine();//被加数
            System.out.println(AddLongInteger(add, aug));
        }
    }
    public static String AddLongInteger(String addend,String augend){
        //先转化为整型
        BigInteger add = new BigInteger(addend);
        BigInteger aug = new BigInteger(augend);
        return String.valueOf(add.add(aug));
    }
}
