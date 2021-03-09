import java.util.Stack;
/*
股票价格跨度https://leetcode-cn.com/problems/online-stock-span/solution/jia-yi-ge-kua-du-zhan-jin-xing-fu-zhu-by-yuan_bao/
 */
class StockSpanner {
    //用栈来实现
    public Stack<Integer> prices;//价格栈
    public Stack<Integer> weight;//跨度栈
    //构造方法
    public StockSpanner() {
        prices = new Stack<>();
        weight = new Stack<>();
    }

    public int next(int price) {
        //价格入栈的时候，如果栈中存在比它小的价格，则将它弹出，并且将它的跨度加到新加入价格的跨度上面
        int w = 1;//每一个价格的跨度至少为1
        if (prices.empty()){
            prices.push(price);
            weight.push(w);
        }
        while(!prices.empty() && price >= prices.peek()){
            prices.pop();
            w += weight.pop();//跨度也随之弹出，并且加入到它的weight里面
        }
        prices.push(price);//新价格入栈
        weight.push(w);
        return weight.peek();
    }
}



public class TestDemo6 {
}
