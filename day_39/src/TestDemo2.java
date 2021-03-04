import java.util.*;
public class TestDemo2 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            //直接俩头向中间遍历
            String s = scan.next();
            char[] ch = s.toCharArray();
            int start = 0;
            int end = ch.length-1;
            String res = "YES";
            while(start < end){
                if(ch[start] == ch[end]){
                    start++;
                    end--;
                }else if(ch[start] == ch[end-1]){
                    end--;
                }else if(ch[start+1] == ch[end]){
                    start++;
                }else{
                    res = "NO";
                    break;
                }
            }
            System.out.println(res);
        }
    }
}