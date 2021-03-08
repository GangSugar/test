
/*
将数组分为和相等的三个部分https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 */

//方法一
class Solution1 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int num : A) {
            sum += num;//存放总和
        }
        if (sum % 3 != 0) {
            return false;
        }
        int target = sum / 3;//因为分三个相等数组
        int n = A.length, i = 0, cur = 0;
        while (i < n) {
            cur += A[i];//开始累加找第一个sum/3
            if (cur == target) {
                break;//找到i之后1提前跳出
            }
            ++i;
        }
        //不确定是找到了跳出循环，还是已经遍历完，从循环中出来了
        if (cur != target) {
            return false;
        }
        int j = i + 1;//下一个sum/3从i+1开始
        while (j + 1 < n) {  // 需要满足最后一个数组非空
            cur += A[j];//其中cur是从上一次的sum/3开始的，因此判断条件是2倍
            if (cur == target * 2) {
                return true;
            }
            ++j;
        }
        //到了这一步说明没有找到
        return false;
    }
}

public class TestDemo5 {
    public static void main(String[] args) {

    }
}
