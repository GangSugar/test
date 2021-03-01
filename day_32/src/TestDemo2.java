public class TestDemo2 {
    public int countNumberOf2s(int n) {
        //超时
//        int count=0;//用来计数
//        if(n<2) return 0;
//        if(n<=10) return 1;
//        for(int j=2;j<=n;j++){
//            int m = j;
//            while(m > 0){
//                if(m%10 == 2)
//                    count++;
//                m/=10;
//                if(m == 0) break;
//            }
//        }
//        return count;

        int count = 0;
        for(int i = 1;i <= n;i *= 10){
            count += (n/i+7)/10*i + (n/i%10==2?n%i+1:0)  ;
        }
        return count;
    }
}
