import java.util.ArrayList;
import java.util.List;

//杨辉三角
public class YangHu {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0) {
            return null;
        }
        List<List<Integer>> ret = new ArrayList<>();

        //第一行
        List<Integer> one = new ArrayList<>();
        one.add(1);
        ret.add(one);
        //从第2行开始放
        for (int i = 1; i < numRows ; i++) {
            //每一行进来 都要一个list  --》 curRow
            List<Integer> curRow = new ArrayList<>();
            //当前行的 第0列 放一个1
            curRow.add(1);
            //前一行
            List<Integer> preRow = ret.get(i-1);
            //从当前行的第1列开始
            for (int j = 1; j < i; j++) {
                int tmp = preRow.get(j)+preRow.get(j-1);
                curRow.add(tmp);
            }
            curRow.add(1);
            //当前行都添加完了
            ret.add(curRow);
        }
        return ret;
    }
}
