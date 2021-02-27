import java.util.Scanner;

public class TestDemo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            //1.先接受一行数据
            String str = scan.nextLine();
            //放入到字符数组中
            char[] b = str.toCharArray();
            for(int i = 0;i< b.length;i++){
                char c = b[i];
                if(c-'A'>=0){
                    c =(char)( c >'E'? (c-5 ): (c+21));
                    b[i] = c;
                }
            }
            System.out.println(new String(b));

        }
    }
}

