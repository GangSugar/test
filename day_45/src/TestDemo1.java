//import java.util.*;
//public class TestDemo1 {
//    public static void main (String[] args) {
//        Scanner scan = new Scanner(System.in);
//        while(scan.hasNext()){
//            String str = scan.nextLine();
//            String[] s = str.split(" ");
//            String a = s[0];
//            String b = s[1];
//            //直接用数组
//            int[] arr1 = new int[26];
//            int[] arr2 = new int[26];
//            for (int i = 0;i < a.length();i++){
//                char ch = a.charAt(i);
//                arr1[ch-'A']++;
//            }
//            for (int i = 0;i < b.length();i++){
//                char ch = b.charAt(i);
//                arr2[ch-'A']++;
//            }
//            int i = 0;
//            for (;i < 26;i++){
//                if(arr2[i] != 0 && arr2[i] <= arr1[i]){
//                    continue;
//                }
//                if (arr2[i] != 0 && arr2[i] > arr1[i]){
//                    break;
//                }
//            }
//            if (i == 26){
//                System.out.println("Yes");
//            }else{
//                System.out.println("No");
//            }
//        }
//    }
//}

import java.util.*;
public class TestDemo1 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            String[] s = str.split(" ");
            String a = s[0];
            String b = s[1];
            //直接HashMap
            Map<Character,Integer> map1 = new HashMap<>();
            Map<Character,Integer> map2 = new HashMap<>();
            for (int i = 0;i < a.length();i++){
                char ch = a.charAt(i);
                if (!map1.containsKey(ch)){
                    map1.put(ch,1);
                }else {
                    map1.put(ch, map1.get(ch)+1);
                }
            }
            for (int i = 0;i < b.length();i++){
                char ch = a.charAt(i);
                if (!map2.containsKey(ch)){
                    map2.put(ch,1);
                }else {
                    map2.put(ch, map2.get(ch)+1);
                }
            }
            int i = 0;
            for (;i < 26;i++){
                if (map1.containsKey((char)(i+'A'))){
                    if (map1.get((char)(i+'A')) > map2.get((char)(i+'A'))){
                        System.out.println("No");
                        break;
                    }
                }
            }
            if (i == 26){
                System.out.println("Yes");
            }
        }
    }
}