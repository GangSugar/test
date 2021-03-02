public class TestDemo2 {
    /**
     * 计算你能获得的最大收益
     *
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    public static int calculateMax(int[] prices) {
        int first = Integer.MAX_VALUE;//第一次买入股票的价格
        int first1 = 0;//第一次卖出
        int second = Integer.MIN_VALUE;//第二次买入
        int second1 = 0;//第二次卖出
        for(int i = 0;i < prices.length;i++){
            //1.第一次买进来的时候价格应该越小越好
            first = Math.min(prices[i],first);
            //2.第一次卖出的收益，应该是当前的价格减去第一次买进来的时候价格
            first1 = Math.max(first1,prices[i]-first);
            //3.第二次买进来的收益，是第一次卖出去的收益-当前价格
            second = Math.max(second,first1-prices[i]);
            //4.第二次卖出去后的收益，是第二次买进的收益+当前价格
            second1 = Math.max(second1,second+prices[i]);
        }
        return second1;
    }

    public static void main(String[] args) {

    }
}