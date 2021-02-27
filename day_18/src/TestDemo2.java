public class TestDemo2 {
    public static void main(String[] args) {
        //一个给100000，一个比前面一天多1分
        //1.首先计算百万的
        int n = 10*30;//单位是万元
        //2.等比数列前n项和
        int m = (int)(1*(1-Math.pow(2,30))/(1-2));
        System.out.println(n+"万"+" "+m+"分");
    }
}
