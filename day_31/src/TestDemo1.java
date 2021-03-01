import java.util.Scanner;
//牛客说反话
public class TestDemo1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        String str=sc.nextLine();
        String[] b=str.split(" ");
        for(int i=b.length-1;i>=0;i--){
            sb.append(b[i]);
            if(i==0){
                break;
            }
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
