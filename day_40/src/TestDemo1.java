import java.util.*;
//删除公共字符
public class TestDemo1 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            //直接用set
            String s1 = scan.nextLine();
            String s2 = scan.nextLine();
            //首先遍历s2
            Set<Character> set2 = new HashSet<>();
            for(int i = 0;i < s2.length();i++){
                char ch = s2.charAt(i);
                set2.add(ch);
            }
            //开始遍历s1
            StringBuffer res = new StringBuffer();
            for(int i = 0;i < s1.length();i++){
                char ch = s1.charAt(i);
                if(!set2.contains(ch)){
                    res.append(ch);
                }
            }
            System.out.println(res.toString());
        }
    }
}