import java.util.*;
//简单错误记录
public class TestDemo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> names = new ArrayList<>();//保存文件名和行号
        List<Integer> num = new ArrayList<>();//计数
        while(scan.hasNext()){
            String[] strs = (scan.next()).split("\\\\");//以\将目录与文件名分开
            String name = strs[strs.length-1];//获取文件名，数组最后一个元素就是文件名
            name = name+" "+scan.next();//将文件名字与错误次数合并在一起
            int index = names.indexOf(name);//获取元素的索引，也就是所在行号
            if(index != -1){//如果已存在，那就光改变数量
                num.set(index,num.get(index)+1);//对应行号，次数加1
            }else{//否则就将新的错误记录加进去
                names.add(name);
                num.add(1);//并且对应记录错误次数置为1
            }
        }

        String[] namesArr = new String[names.size()];
        names.toArray(namesArr);//将文件名集合转换为数组
        Integer[] nums = new Integer[num.size()];//每种文件对应的个数
        num.toArray(nums);
        //排序，遍历个数大小(根据错误数组从多到少排序)
        for(int i=0; i<namesArr.length; i++){
            int maxindex = i;
            for(int j=i+1; j<namesArr.length; j++){
                if(nums[j] > nums[maxindex]){
                    maxindex = j;
                }
            }
            //根据个数多的下标，来交换文件位置，
            String name1 = namesArr[maxindex];
            System.arraycopy(namesArr,i,namesArr,i+1,maxindex-i);
            namesArr[i] = name1;
            //然后再把个数位置交换
            Integer sum1 = nums[maxindex];
            System.arraycopy(nums,i,nums,i+1,maxindex-i);
            nums[i] = sum1;
//            String tmp = namesArr[maxindex];
//            namesArr[maxindex] = namesArr[i];
//            namesArr[i] = tmp;
//
//            Integer sum1 = nums[maxindex];
//            nums[maxindex] = nums[i];
//            nums[i] = sum1;
        }
        //输出
        for(int i=0; i<Math.min(namesArr.length,8); i++){
            String name = namesArr[i];
            String a = name.split(" ")[0];//获取文件名
            String b = name.split(" ")[1];//获取行号
            //文件名长度大于16  截取后16位
            if(a.length()>16){
                name = a.substring(a.length()-16)+" "+b;
            }
            System.out.println(name+" "+nums[i]);
        }
    }
}