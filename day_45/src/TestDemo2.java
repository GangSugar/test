import java.util.*;
public class TestDemo2 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            String[] str = new String[n];
            String[] res = new String[n+1];
            for(int i = 0;i < n;i++){
                str[i] = scan.next();
            }
            Arrays.sort(str);//排序
            String s = scan.next();//要查找的单词
            int m = scan.nextInt();
            int count = 0;
            int index = 1;
            boolean flag = false;
            for(int i = 0;i < n;i++){
                if(!s.equals(str[i])){
                    flag = is(s,str[i]);//判断是不是兄弟
                    if(flag){//是兄弟
                        count++;
                        res[index++] = str[i];
                    }
                }
            }
            System.out.println(count+" ");
            if(m <= count){
                System.out.println(res[m]);
            }
        }
    }
    public static boolean is(String s1,String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        //转化为字符数组，并且排序对比
        char[] ch1 = s1.toCharArray();
        Arrays.sort(ch1);
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch2);

        return new String(ch1).equals(new String(ch2));
    }
}