
//顺序表
class MyArrayList{
    public int[] elem ;
    public int usedSize;
    //构造方法
    public  MyArrayList(){
        this.elem = new int[10];
        this.usedSize = 0;
    }

    public MyArrayList(int count) {
        this.elem = new int[count];
        this.usedSize = 0;
    }
    //打印顺序表
    public void display(){
        for (int i = 0;i < usedSize;i++){
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
    //在pos位置新增元素
    public void add(int pos ,int data){
        //0.判断是否合法
        //1.判断是否满了
        //3.移动数据需要从后开始移动
        if (pos < 0 || pos >usedSize){
            System.out.println("插入位置不合法!");
            return;
        }
        if (this.usedSize == this.elem.length){
            System.out.println("已经满了，无法插入");
            return;
        }
        for (int i = usedSize-1;i >= pos;i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }
    //判断是否包含某一个元素
    public boolean contains(int toFind){
        for (int i = 0;i < usedSize;i++){
            if (toFind == elem[i]){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (toFind == elem[i]) {
                return i;
            }
        }
        return -1;
    }
    //获取pos位置的元素
    public int getPos(int pos){
        //如果pos合法，则遍历顺序表
        if (pos < 0 || pos >= usedSize){
            System.out.println("插入位置不合法!");
            return -1;
        }
        return elem[pos];
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value){
        //如果pos位置合法，则直接换值
        if (pos < 0 || pos > usedSize){
            System.out.println("插入位置不合法!");
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int key){
        //直接遍历数组，找到后，直接将后面的值一个一个移动前来，覆盖关键字key的位置
        //然后usedSize--
        int i = search(key);
        if (i == -1){
            System.out.println("没有这个数字");
            return;
        }
        for (;i < usedSize-1 ;i++){
            elem[i] = elem[i+1];
        }
        usedSize--;
    }
    //删除多次出现的关键字key
    public void removeAll(int key){
        //先获取有几个关键字
        int count = 0;
        for (int i = 0;i < usedSize;i++){
            if (key == elem[i]){
                count++;
            }
        }
        for (int j = 0;j < count;j++){
            remove(key);
        }
    }
    // 获取顺序表长度
    public int size(){
        return this.usedSize;
    }
    // 清空顺序表
    public void clear(){
        this.usedSize = 0;
    }
}


public class TestDemo {
    public static void main(String[] args) {
        /*
        测试自己的MyArrayList
         */
        MyArrayList myArrayList = new MyArrayList(5);
        myArrayList.add(0,1);//指定位置添加元素
        myArrayList.add(0,5);
        myArrayList.add(0,15);
        myArrayList.display();
        myArrayList.add(3,9);
        myArrayList.display();
        myArrayList.add(-1,5);
        myArrayList.add(4,6);
        myArrayList.display();
        /*myArrayList.removeAll(1);
        myArrayList.display();*/
        System.out.println("包含是true，不包含是false: "+myArrayList.contains(7));
        System.out.println("对应元素的位置pos是(-1代表没有该元素): "+myArrayList.search(6));
        System.out.println("pos位置的元素: "+myArrayList.getPos(3));
        myArrayList.setPos(3,100);//将pos位置设为给定值，设置完可以调用display
        myArrayList.display();
        myArrayList.removeAll(5);//删除第一次出现的关键字
        System.out.print("删除第一次出现关键字后的顺序表中的元素: ");
        myArrayList.display();
        System.out.println("顺序表的长度: "+myArrayList.size());//获取顺序表的长度
    }
}
