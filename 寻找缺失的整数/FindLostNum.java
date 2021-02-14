package 寻找缺失的整数;

public class FindLostNum {
    public static int[] findLostNum(int[] arr){
        //用于存储2个出现奇数次的整数
        int result[] = new int[2];
        //1.第1次进行整体异或运算
        int res = 0;
        for (int i = 0;i < arr.length;i++){
            res ^= arr[i];
        }
        //如果进行异或运算的结果为0，则说明输入的数组不符合题目要求
        if (res == 0){
            return null;
        }
        //2.确定2个整数的不同位，以此来作为分组依据
        int separator = 1;
        while ((res & separator) == 0){
            separator <<= 1;//进行左移
        }
        //3.第二次分组进行异或运算
        for (int i = 0;i < arr.length;i++){
            if ((arr[i] & separator) == 0){
                result[0] ^= arr[i];
            }else{
                result[1] ^= arr[i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] array = {4,1,2,2,5,1,4,3};
        int[] result = findLostNum(array);
        if (result[0] < result[1]){
            System.out.println(result[0]+" "+result[1]);
        }else{
            System.out.println(result[1]+" "+result[0]);
        }

    }
}
