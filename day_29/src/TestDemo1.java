//牛客中奖概率
import java.util.*;
public class TestDemo1{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int n=scan.nextInt();
            double sum1=count(n);//每个人都不可能抽中中奖，出现的情况个数
            double sum2=anything(n);//抽奖所有可能出现的情况
            double result=(sum1/sum2)*100;
            System.out.println(String.format("%.2f",result)+"%");
        }
    }
    //所有中奖的情况
    public static double count(int n){
        if(n==1){
            return 0;
        }else if(n==2){
            return 1;
        }else{
            return (n-1)*(count(n-1)+count(n-2));
        }
    }
    //所有情况
    public static double anything(int num){
        double result=1;
        if(num==0){
            return 1;
        }else if(num>0){
            result=num*anything(num-1);
        }
        return result;
    }
}
