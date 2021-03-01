import java.util.*;
public class TestDemo2 {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            String[] str = new String[n];
            for(int i = 0;i < str.length;i++){
                str[i] = scan.next();
            }
            sort(str,n);
            for (int i = 0;i < str.length;i++) {
                System.out.println(str[i]);
            }
        }
    }
    //用来排序
    public static void sort(String[] s,int n) {
        for (int i = 0;i < n-1;i++){
            for (int j = i+1;j < n;j++){
                if (s[i].length() > s[j].length()){
                    String s1 = s[i];
                    s[i] = s[j];
                    s[j] = s1;
                }else if(s[i].length() == s[j].length()){
                    if (s[i].compareTo(s[j]) > 0){//利用比较器
                        String s1 = s[i];
                        s[i] = s[j];
                        s[j] = s1;
                    }
                }
                //其它情况保持顺序不变
            }
        }
    }
}