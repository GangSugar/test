import java.util.Arrays;

public class MyArrayList {

    public int[] elem;
    public int usedSize;

    public MyArrayList() {
        this.elem = new int[10];
        this.usedSize = 0;
    }

    public MyArrayList(int capcity) {
        this.elem = new int[capcity];
        this.usedSize = 0;//统计顺序表中的值的个数
    }

    public boolean isFull(){
        if (this.usedSize == this.elem.length){
            return true;
        }
        return false;
    }
    //扩展elem存储容量
    public void resize(){
        //进行拷贝
        this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
    }
    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if (pos < 0 || pos > this.usedSize) {
            System.out.println("不合法");
            return;
        }
        if (this.usedSize == this.elem.length) {
            System.out.println("已经满了");
            resize();
        }
        for (int i = usedSize-1; i >= pos; i--) {
            elem[i + 1] = elem[i];
        }
        this.elem[pos] = data;//经过上面的for，pos位置已经空出来了，因此把要插入的data可以插入到pos位置了
        this.usedSize++;//因为添加了元素，所以数量要进行增加
    }
    // 打印顺序表
    public void display() {
        for (int i = 0;i < this.usedSize;i++){
            System.out.print(this.elem[i]+" ");
        }
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0;i < this.usedSize;i++){
            if (toFind == this.elem[i]){
            return true;//表示存在
            }
        }
        return false;//表示不存在
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0;i < this.usedSize;i++){
            if (toFind == this.elem[i]){
                return i;
            }
        }
        return -1;//表示没有找到
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if (pos >= this.usedSize||pos < 0){
            System.out.println("无法获取!");
            return -1;
        }
        /*for (int i = 0;i < this.usedSize;i++){
            if (elem[pos] == elem[i]){
                return elem[i];
            }
        }
        return -1;return*/
        return this.elem[pos];
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if (pos >= this.usedSize||pos < 0){
            System.out.println("不合法!");
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int pos = search(toRemove);
        if (pos >= this.usedSize||pos < 0){
            return;
        }
        for (int i = pos;i <this.usedSize-1;i++){
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;//因为删除，所以存储空间要进行减少
    }
    //删除出现多次的关键字key
    public void removeAll(int toRemove){
        if (!contains(toRemove)){
            return;
        }
        while(contains(toRemove)){
            remove(toRemove);
        }
    }
    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
}
