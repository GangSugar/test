public class TestDemno1 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
//        BigInteger arr = new BigInteger(String.valueOf(a));
//        BigInteger add = new BigInteger(String.valueOf(b));
//        System.out.println(Integer.parseInt(String.valueOf(arr.add(add))));

        /**
         * 第二种方法
         */
        int sum = sum(a,b);
        System.out.println(sum);
    }
    public static int sum(int a,int b){
        if (b == 0){
            return a;
        }
        int newa = a^b;
        int newb = (a&b)<<1;
        return sum(newa,newb);
    }
}
