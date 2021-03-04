import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestDemo3 {
    public static void main1(String[] args) {
        String[] arr = new String[]{"1","2","3","4"};
        listAll(Arrays.asList(arr),"");//aList
    }
    public static void listAll(List cand,String prefix){
        System.out.println(prefix);//打印
        System.out.println("tmp2好"+cand.size());
        //System.out.println(cand.size());
        for (int i = 0;i < cand.size();i++){
            List tmp = new LinkedList(cand);
            System.out.println("tmp:"+tmp.size());
            listAll(tmp,prefix+tmp.remove(i));
        }
    }
    
}
