import java.util.*;
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String s = scan.nextLine();
            //直接一个HashMap
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0;i < s.length();i++){
                int tmp = (int)s.charAt(i);
                if(map.get(tmp) == null){
                    map.put(tmp,1);
                }else{
                    map.put(tmp,map.get(tmp)+1);
                }
            }
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                System.out.println(entry.getKey()-(int)'0'+":"+entry.getValue());
            }

        }
    }
}

/*
import java.util.*;
public class Main{
public static void main(String []args){
Scanner sc =new Scanner(System.in);
String s = sc.nextLine();
int num[]=new int[10];
for(char c : s.toCharArray()){
num[c-'0']++;
}
for(int i = 0;i<10;i++){
if(num[i] != 0)
System.out.println(i+":"+num[i]);
}
}
}
 */