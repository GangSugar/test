public class Test {
        public static void main1(String[] args) {
        System.out.println("hello");
        int n = 15;
        int count = 0;
        while(n != 0){
            count++;
            n = n&(n-1);
        }
        System.out.println("1的个数是："+count);
    }
}

