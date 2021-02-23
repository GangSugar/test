import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Testdemo2 {
    public static void main(String[] args) {
        //1.首先输入俩个字符串
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        //2.将str2放入Hashset，然后遍历str1将不再里面的放入结果中
        StringBuffer result = new StringBuffer();
        Set<Character> set = new HashSet<>();
        for (int i = 0;i < str2.length();i++){
            set.add(str2.charAt(i));
        }
        //3.遍历str1
        for (int i = 0;i < str1.length();i++){
            if(!set.contains(str1.charAt(i))){
                result.append(str1.charAt(i));
            }
        }
        //4.输出result
        System.out.println(result.toString());
    }
}
