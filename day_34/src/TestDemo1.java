import java.util.*;
//牛客坏键盘
public class TestDemo1 {


    public static void func(String strMust,String strAct) {
        //1、吧实际输出的字符strAct  放到  集合
        HashSet<Character> setAct = new HashSet<>();

        for (char ch :strAct.toUpperCase().toCharArray()) {
            setAct.add(ch);
        }
        //此时setAct当中 存放的 就是 实际输出的字符
        //2、遍历strMust
        HashSet<Character> setBroken = new HashSet<>();

        char[] strMustS = strMust.toUpperCase().toCharArray();
        for (char ch2  : strMustS ) {
            //ch2是个坏键盘
            if(!setAct.contains(ch2) && !setBroken.contains(ch2)) {
                setBroken.add(ch2);//7 T I
                System.out.print(ch2);
            }
        }
    }
    public static void main(String[] args) {

        Scanner sca = new Scanner(System.in);
        while(sca.hasNextLine()) {
            String strMust = sca.nextLine();
            String strAct = sca.nextLine();
            func(strMust,strAct);
        }

    }
}

