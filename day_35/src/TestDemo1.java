public class TestDemo1 {
    public static void main (String[] args){
        //int n = (1-Math.pow(2,30))/(1-2);//百万富翁(分)
        long n = (long)Math.pow(2,30)-1;
        int m = 10*30;//陌生人(万)
        System.out.println(m+" "+n);
    }
}