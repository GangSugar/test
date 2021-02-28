import java.util.*;
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();//课程数
            //学分
            int[] arr = new int[n];
            for(int i = 0;i < n;i++){
                arr[i] = scan.nextInt();
            }
            //实际得分
            int[] score = new int[n];
            for(int i = 0;i < n;i++){
                score[i] = scan.nextInt();
            }
            double GPA = 0;
            int xf = 0;
            for(int i = 0;i < n;i++){
                GPA += point(score[i])*arr[i];
                xf += arr[i];
            }
            System.out.println(GPA);
            System.out.printf("%.2f",GPA/xf);
        }
    }
    public static double point(int grade){
        if(grade>=90&&grade<=100)
        {
            return 4.0;
        }
        else  if(grade>=85&&grade<=89)
        {
            return 3.7;
        }else  if(grade>=82&&grade<=84)
        {
            return 3.3;
        }
        else  if(grade>=78&&grade<=81)
        {
            return 3.0;
        }
        else  if(grade>=75&&grade<=77)
        {
            return 2.7;
        }
        else  if(grade>=72&&grade<=74)
        {
            return 2.3;
        }
        else  if(grade>=68&&grade<=71)
        {
            return 2.0;
        }
        else  if(grade>=64&&grade<=67)
        {
            return 1.5;
        }
        else  if(grade>=60&&grade<=63)
        {
            return 1.0;
        }
        else
        {
            return 0.0;
        }
    }
}