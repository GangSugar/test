import java.util.Arrays;

public class TestDemo1 {
    public static boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        //1.首先定义一个自定义布尔数组
        boolean[] arr = new boolean[n];
        //2.开始遍历字符串数组p
        for(int i = 0;i < n;i++){
            String str = p[i];//临时 存储数组的值
            if(str.length() <= s.length()){
                if(s.contains(str))arr[i] = true;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        String[] str = {"a","b","c","d"};
        System.out.println(Arrays.toString(chkSubStr(str, 4, "abc")));
    }
}
