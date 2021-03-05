import java.util.*;
public class TestDemo1 {
    public static void main (String[] args) {
        int[] mouth = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int y = scan.nextInt();
            int m = scan.nextInt();
            int d = scan.nextInt();
            int sum = 0;
            /*switch (m){
            case 1: sum = d;break;
            case 2: sum = 31+d;break;
            case 3: sum = 31+28+d;break;
            case 4: sum = 31+28+31+d;break;
            case 5: sum = 31+28+31+30+d;break;
            case 6: sum = 31+28+31+30+31+d;break;
            case 7: sum = 31+28+31+30+31+30+d;break;
            case 8: sum = 31+28+31+30+31+30+31+d;;break;
            case 9: sum = 31+28+31+30+31+30+31+31+d;break;
            case 10: sum = 31+28+31+30+31+30+31+31+30+d;break;
            case 11: sum = 31+28+31+30+31+30+31+31+30+31+d;break;
            case 12: sum = 31+28+31+30+31+30+31+31+30+31+30+d;break;
            default : break;
            }
            if(year(y)){
                sum++;
                System.out.println(sum);
            }else{
                System.out.println(sum);
            }*/
            //第二种方法
            mouth[2] = 28;
            if(year(y)){
                mouth[2] = 29;
            }
            for(int i = 1;i < m;i++){
                sum += mouth[i];
            }
            System.out.println(sum+d);
        }
    }
    //判断是是不是闰年
    public static boolean year(int y){
        if((y % 4 ==0 && y % 100 != 0) || y % 400 == 0){
            return true;
        }
        return false;
    }
}