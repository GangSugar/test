import java.util.*;
public class TestDemo2 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String[] str = scan.nextLine().split(";");
            int x = 0;
            int y = 0;
            for(int i = 0;i < str.length;i++){
                if(str[i].length() > 0&&str[i].length() <= 3){//因为数字在俩位以内
                    //使用正则表达式
                    if(str[i].charAt(0) == 'A' && str[i].substring(1).matches("[0-9]+")){
                        x -= Integer.parseInt(str[i].substring(1));
                    }
                    if(str[i].charAt(0) == 'D' && str[i].substring(1).matches("[0-9]+")){
                        x += Integer.parseInt(str[i].substring(1));
                    }
                    if(str[i].charAt(0) == 'W' && str[i].substring(1).matches("[0-9]+")){
                        y += Integer.parseInt(str[i].substring(1));
                    }
                    if(str[i].charAt(0) == 'S' && str[i].substring(1).matches("[0-9]+")){
                        y -= Integer.parseInt(str[i].substring(1));
                    }
                }
            }
            System.out.println(x+","+y);
        }
    }
}