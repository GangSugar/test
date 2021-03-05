import java.util.*;
//牛客句子逆序
public class TestDemo2 {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String s = scan.nextLine();
            System.out.println(reverse(s));
        }
    }
    public static String reverse(String sentence) {
        String[] s = sentence.split(" ");
        //直接遍历，逆序
        int start = 0;
        int end = s.length-1;
        while(start < end){
            //交换
            String tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
        //拼接一下结果
        StringBuffer res = new StringBuffer();
        for(int i = 0;i < s.length-1;i++){
            res.append(s[i]).append(" ");
        }
        res.append(s[s.length-1]);
        return res.toString();
    }
}