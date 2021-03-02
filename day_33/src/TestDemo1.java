import java.util.*;
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[][] arr = new String[n][2];//输入的组数
        int[] left = new int[3];//甲赢的三种手势的个数
        int[] right = new int[3];//乙赢的三种手势的个数
        int win = 0;//赢
        int p = 0;//平
        int mistake = 0;//输
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = scan.next();
            }
        }

        //统计双方赢、平、输的次数
        for (int i = 0; i < arr.length; i++) {//赢的次数
            if(arr[i][0].equals("C")&&arr[i][1].equals("J") || arr[i][0].equals("J")&&arr[i][1].equals("B") || arr[i][0].equals("B")&&arr[i][1].equals("C")){
                left = f(left,arr[i][0]);
                win++;
            }else if(arr[i][0].equals("C")&&arr[i][1].equals("C") || arr[i][0].equals("J")&&arr[i][1].equals("J") || arr[i][0].equals("B")&&arr[i][1].equals("B")){
                p++;//平的次数
            }else{
                right = f(right,arr[i][1]);//这是甲输，但是是乙的时候
                mistake++;
            }
        }
        System.out.println(win+" "+p+" "+mistake);//甲的情况
        System.out.println(mistake+" "+p+" "+win);//乙的情况
        str(left);
        System.out.print(" ");//输出空格
        str(right);
    }

    //判断赢的手势并计数
    static int[] f(int[] arr,String str){
        if(str.equals("C"))
            arr[0]++;
        else if(str.equals("J"))
            arr[1]++;
        else if(str.equals("B"))
            arr[2]++;
        return arr;
    }

    //输出双方赢得最多的手势
    static void str(int[] arr){
        int max=0;
        String maxstr = "";
        String[] mm = new String[] {"C","J","B"};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]<arr[j]){
                    max = arr[j];
                    arr[j] = arr[i];
                    arr[i] = max;

                    maxstr = mm[j];
                    mm[j] = mm[i];
                    mm[i] = maxstr;
                }
            }
        }
        if(arr[0]==arr[1]){
            if(arr[1]==arr[2]){
                System.out.print("B");
            }else{
                if(mm[0].compareTo(mm[1])>0){
                    System.out.print(mm[1]);
                }else{
                    System.out.print(mm[0]);
                }
            }
        }else{
            if(arr[1]==arr[2]){
                System.out.print(mm[0]);
            }else{
                System.out.print(mm[0]);
            }
        }
    }
}