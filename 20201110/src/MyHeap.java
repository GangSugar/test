import java.util.Arrays;
import java.util.List;
//因为堆是完全二叉树，因此采用顺序存储
public class MyHeap {
    int[] elem;
    int usedSize;
    public MyHeap(){
        this.elem = new int[15];
    }

    //向下调整的方法构造堆(大根堆)(时间复杂度log2n)
    //向下调整的意思就是，从每一棵子树的视角来看是从它的双亲节点往下调整的所以叫向下调整的
    //参数传入的parent是最后一棵子树双亲下标，len就是usedSize，堆中节点的个数
    public void adjustDown(int parent,int len){
        int child = 2*parent+1;//左孩子下标
        //1.首先判断是不是有左孩子
        while(child < len){
            //是否有右孩子，如果有的话，child保存的是左右孩子中最大值的下标；
            if (child+1 < len && elem[child] < elem[child+1]){
                child++;//因为右孩子值大，所以将child的值变为右孩子的下标
            }
            //到这步，说明已经确定左右孩子中最大值的下标了，则和双亲节点开始进行比较
            if(elem[child] > elem[parent]){
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                //下面这俩个式子用来进行判断子树，是否已经构造完毕
                parent = child;//向下进行判断，所以要等于孩子节点
                child = 2*parent+1;
            }else{//否则直接跳出循环，因为只要双亲节点大于孩子中最大值，那么子树一定已经构造成为一棵大根堆
                break;
            }
        }
    }
    //将数组先放入堆中，然后调用向下调整方法(adjustDown)，构造堆
    public void initHeap(int[] arr){
        for (int i = 0;i < arr.length;i++){
            elem[i] = arr[i];
            usedSize++;
        }
        //建堆时间复杂度O(n*log2n)，一棵子树完成后，j就减减，这样就能够找到下一棵子树的双亲下标了
        for (int j = (usedSize-1-1)/2;j >= 0;j--){
            adjustDown(j,usedSize);
        }
    }

    //用向上调整的方法构造堆(向上调整就是从孩子节点向上，向双亲节点调整)
    public void adjustUp(int child){
        int parent = (child-1)/2;
        /*
       因为是向上走，因此下标肯定是从小到大，最后到根节点是0，所以这里是大于0;child等于0;这个堆就已经走完了
       */
        while(child > 0){
            if(elem[child] > elem[parent]){//构造的是大根堆
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;//把父亲节点作为下一次的孩子节点
                parent = (child-1)/2;
            }else{
                break;
            }
        }
    }

    //模拟队列形式，给堆添加新元素
    public void push(int val){
        //1.首先判断该堆的存储大小是否已经满了，如果满了要进行扩容
        if (isFull()){
            this.elem = Arrays.copyOf(this.elem,elem.length*2);//空间扩展为原来的二倍
        }
        elem[usedSize] = val;//将新的值，直接加到堆的最后面
        usedSize++;//进行加加，说明堆中元素又多了一个；
        adjustUp(this.usedSize-1);//然后从孩子开始，向上进行调整
    }

    //判断堆是否已经满了
    public boolean isFull(){
        return this.usedSize == this.elem.length;
    }
    //出堆(弹出堆顶元素)
    public int pop(){
        /*
        思路：将堆定元素和堆最后一个元素进行交换，然后弹出，并且将堆重新进行调整
         */
        //判断是否为空
        if (isEmpty()){
            return -1;
        }
        // 1.交换，堆头和堆尾
        int tmp = elem[0];
        this.elem[0] = this.elem[this.usedSize-1];
        this.elem[this.usedSize-1] = tmp;
        this.usedSize--;//数据个数减少
        //2.调用向下调整方法
        adjustDown(0,usedSize);
        //System.out.println("=====");
        return tmp;
    }
    //判断是否为空
    public boolean isEmpty(){
        return usedSize == 0;
    }


    //最后一颗石头的重量
    /*
    思路
    1.首先将数据传入进去，然后就行向下调整的方法，构造大根堆；
    2.然后每次都弹出堆的前俩个最大的元素，用第一个y减去第二个x，如果差值大于0，就加入到
      堆里面，这里加入进去的时候，加入到堆的尾巴，直接调用向上调整的方法
    3.循环结束的条件是，堆为空，或者只剩下最后剩下一个元素，然后直接弹出，也就是我们需要返回的值
     */
    /*public int lastStoneWeight(int[] stones) {
        int size = stones.length;
        if (size == 0)return 0;
        if(size == 1)return stones[0];
        //1.将数据放入堆中,就能够构造出来一个大根堆
        initHeap(stones);
        //2.接着开始弹出堆头的前面俩个元素
        while(size > 1){
            int y = pop();
            size--;
            int x= pop();
            size--;
            int newval = y-x;
            if (newval > 0){
                push(newval);
                size++;
            }
        }
        if (size == 0)return 0;
        return pop();
    }*/

    //堆排
    public void heapsort(){
        int end = usedSize-1;
        while(end > 0) {
            int tmp = elem[0];
            elem[0] = elem[end];
            elem[end] = tmp;
            adjustDown(0,end);
            end--;
        }
    }
    public void show(){
        for (int i =0;i < usedSize;i++){
            System.out.print(this.elem[i]+" ");
        }
    }
}
