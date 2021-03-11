import java.util.Scanner;

public class TestDmeo5 {
    public static int find(String str1,String str2){
        //寻找回文串
        //1.首先遍历str1,判断方法，双指针
        int count = 0;
        if(find1(str2+str1)){//直接加在头
            count++;
        }
        if(find1(str1+str2)){//直接加在尾巴
            count++;
        }
        for(int i = 0;i < str1.length()-1 ;i++){//中间部分
            String str3 = str1.substring(0,i+1);//左闭右开
            String str4 = str1.substring(i+1, str1.length());
            String str5 = str3+str2+str4;
            if(find1(str5)){
                count++;
            }
        }
        return count;
    }
    //用来合并字符串，并且判断是否为回文
    public static boolean find1(String str1){
        int start =0;int end = str1.length()-1;
        for (;start < str1.length();){
            if(str1.charAt(start) == str1.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*String str1 ="aba";
        String str2 ="b";*/
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        int k = find(str1,str2);
        System.out.println(k);}

    }
}
