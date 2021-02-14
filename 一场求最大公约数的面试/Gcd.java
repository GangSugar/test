package 一场求最大公约数的面试;

/**
 * 最大公约数
 */
public class Gcd {
    public static int gcd (int a,int b){
        //辗转相除法
        while (b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
    public static int gcd2(int a,int b){
        int big = a > b ? a : b;
        int small = a<b ? a:b;
        if (big % small == 0){
            return small;
        }
        return gcd(big % small,small);
    }

    /**
     * 3.更相减损术
     * 解题思路：等于俩数差和最小数之间的最大公约数
     * 可以避免大整数取余数，从而性能
     * 缺点是，如果俩数差距太大，递归次数就太多了，例如10000和1
     * @param a
     * @param b
     * @return
     */
    public static int gcd3(int a,int b){
        if (a == b){
            return a;
        }
        int big = a > b ? a : b;
        int small = a<b ? a:b;

        return gcd3(big-small,small);
    }

    /**
     * 4.最优的求最大公约数的方法，将辗转相除和更相减损术相互结合
     * @param a
     * @param b
     * @return
     */
    public static int gcd4(int a,int b){
        if (a == b){
            return a;
        }
        if((a & 1) == 0 && (b & 1) == 0){//俩个都是偶数
            return gcd4(a >> 1,b >> 1);

        }else if((a&1)==0 && (b&1)!=0){
            return gcd(a>>1, b);

        }else if((a&1)!=0 && (b&1)==0){
            return gcd(a, b>>1);
        }else {//俩个都是奇数
            int big = a>b ? a:b;
            int small = a<b ? a:b;
            return gcd(big-small, small);
        }
    }
    public static void main(String[] args) {
        System.out.println(gcd2(12,8));
        System.out.println(gcd3(100,80));
    }
}
