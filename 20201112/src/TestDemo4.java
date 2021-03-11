import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestDemo4 {
    /*public static int find(String[][] str){
        //输入字符串二维数组，找出所有不同的，计算数量
        Set<String> set = new HashSet<>();
        //先将第0行放入进去
        for(int i = 0;i < str[0].length;i++){
            set.add(str[0][i]);
        }
        //接下来遍历后面的
        for(int i = 1;i < str.length;i++){
            for(int j =  0;j < str[i].length;j++){
                set.add(str[i][j]);
            }
        }
        return set.size();

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){

            int k  = find(str);
            System.out.println(k);}
    }*/

    /*public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (scan.hasNext()) {
            String string = scan.nextLine();
            int i = 0;
            while (i < string.length()){
                StringBuffer sb = new StringBuffer();
                while (i<string.length() && string.charAt(i)!=' '){
                    sb.append(string.charAt(i));
                    i++;
                }
                i++;
                set.add(sb.toString());
            }
        }
        System.out.println(set.size());
    }*/
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (scan.hasNext()){
            String str = scan.nextLine();
            String[] str1 = str.split(" ");//以空格分开
            for(int i = 0;i < str1.length;i++){
                set.add(str1[i]);
            }
            if(str.equals("str"))break;
        }
        System.out.println(set.size());
    }
}
